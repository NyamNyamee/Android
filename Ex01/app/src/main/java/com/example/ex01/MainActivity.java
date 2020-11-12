package com.example.ex01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 버튼생성
    Button loginBtn;

    // 권한체크리스너 생성
    private PermissionListener permissionlistener = new PermissionListener() {
        // 모든 권한 허가시 실행할 메서드
        @Override
        public void onPermissionGranted() {
            Toast.makeText(getBaseContext(), "권한 허가됨", Toast.LENGTH_SHORT).show();
        }
        // 권한 거부시 실행할 메서드
        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(getBaseContext(), "권한 거부됨\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼과 로그인버튼 연결
        loginBtn = findViewById(R.id.loginBtn);

        // 권한체크 시작
        TedPermission.with(this)
                .setPermissionListener(permissionlistener) // 위에서 만든 권한체크리스너 지정
                .setRationaleMessage("권한이 필요합니다 형님!") // 권한 요청 전 띄울 메시지
                .setDeniedMessage("권한 설정을 거부하셨습니다\n[설정] > [권한] 에서 권한을 허용할 있습니다") // 권한 거부시 띄울 내용
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECEIVE_SMS) // manifest에서 지정한 권한 지정
                .check();
    }


    // 메인화면으로 돌아가기
    public void moveToMain(View view) {
        Toast.makeText(this, "Move to main page", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    // 로그인화면으로 가기(요청코드 1004)
    public void moveToLogin(View view) {
        Toast.makeText(this, "Move to login page", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, LoginActivity.class);
        startActivityForResult(intent1, 1004);
    }

    // 데이터 받아오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            // 요청코드가 1004일때(로그인화면에서 받아온 데이터 처리)
            case 1004:
                switch (resultCode) {
                    case 1:
                        Bundle bundle = data.getExtras();
                        String id = bundle.getString("id");
                        String pw = bundle.getString("pw");
                        boolean loginFlag = bundle.getBoolean("login");
                        // Log.d("loginTag", loginFlag + "");
                        // 로그인 성공했다면
                        if (loginFlag) {
                            // 로그인버튼의 텍스트를 Logout으로 변경하고 로그아웃메시지 띄움
                            loginBtn.setText("Logout");
                            // 로그인버튼의 클릭이벤트 변경
                            loginBtn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    // 로그아웃 클릭시 로그아웃 토스트를 띄우고 다시 버튼텍스트를 Login으로 변경
                                    Toast.makeText(getBaseContext(), "Bye " + id + "~!", Toast.LENGTH_SHORT).show();
                                    loginBtn.setText("Login");
                                    // 로그인버튼의 클릭이벤트 변경
                                    loginBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            moveToLogin(v);
                                        }
                                    });
                                }
                            });
                        }
                        break;
                }
                break;
        }

    }

}
