package com.example.dialogex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    // 레이아웃의 버튼을 눌렀을때
    public void showDialog(View view) {
        // 대화상자창 껍데기 생성
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 대화상자 껍데기 설정
        builder.setTitle("대화상자");
        builder.setMessage("종료고?");
        // android에 있는 리소스에서 아이콘을 가져와 아이콘지정
        builder.setIcon(android.R.drawable.ic_dialog_info);

        // 레이아웃의 버튼에 따라 대화상자의 버튼개수를 다르게 설정
        switch (view.getId()) {
            case R.id.btn3:
                // 중립버튼(텍스트, 눌렀을때 이벤트) : 눌렀을때 which 의 값이 -3
                builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "무시무시" + which, Toast.LENGTH_SHORT).show();
                    }
                });

            case R.id.btn2:
                // 거부버튼(텍스트, 눌렀을때 이벤트) : 눌렀을때 which 의 값이 -2
                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "무시무시" + which, Toast.LENGTH_SHORT).show();
                    }
                });

            case R.id.btn1:
                // 확인버튼(텍스트, 눌렀을때 이벤트) : 눌렀을때 which 의 값이 -1
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "무시무시" + which, Toast.LENGTH_SHORT).show();
                    }
                });

        }
        // 다이얼로그를 생성하고 띄우기
        builder.create().show();

        // 스낵바 만들고 누를시 이벤트 실행하는 액션까지 설정
        Snackbar.make(view, "스낵바메시지", BaseTransientBottomBar.LENGTH_LONG).setAction("눌러", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "왜눌러", Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}