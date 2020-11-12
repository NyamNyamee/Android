package com.example.serviceex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.serviceex01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    final private String TAG = "MainActivity";
    private Intent mBasicIntent;
    private Intent mBindIntent;
    private MyBindService myBindService;
    boolean isService = false; // 서비스 중인 확인용

    ServiceConnection conn = new ServiceConnection() {
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 서비스와 연결되었을 때 호출되는 메서드
            // 서비스 객체를 전역변수로 저장
            MyBindService.MyBinder mb = (MyBindService.MyBinder) service;
            myBindService = mb.getService(); // 서비스가 제공하는 메소드 호출하여
            // 서비스쪽 객체를 전달받을수 있슴
            isService = true;
        }
        public void onServiceDisconnected(ComponentName name) {
            // 서비스와 연결이 끊겼을 때 호출되는 메서드
            isService = false;
        }
    };
    // 데이터 바인딩!!! : build.gradle에 추가
    // dataBinding {
    //        enabled true
    // }
    // xml 파일이름을 자바 규칙에 맞게 만들고 뒤에  Binding이라는 문자열을 붙인 클래스가 자동 생성
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMain(this);

        mBasicIntent = new Intent(this, MyService.class);
        mBindIntent = new Intent(this, MyBindService.class);

        binding.startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(mBasicIntent);
            }
        });
        binding.stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(mBasicIntent);
            }
        });
    }

    // 서비스시작
    public void bindServiceButton(View view){
        if (!isService) {
           bindService(this.mBindIntent, conn, BIND_AUTO_CREATE);
        }
    }

    // 서비스중지
    public void unbindServiceButton(View view){
        if (isService) {
            isService = false;
            unbindService(conn);
        }
    }

    // 데이터얻기
    public void getData(View view){
        if (!isService) {
            Toast.makeText(this,"서비스중이 아닙니다, 데이터받을수 없음",Toast.LENGTH_LONG).show();
            return;
        }
        int num = myBindService.getRan();//서비스쪽 메소드로 값 전달 받아 호출
        Toast.makeText(this,"받아온 데이터 : " + num, Toast.LENGTH_LONG).show();
    }

    public void intentServiceButton(View view){
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("message", "어떤 메세지!!!!");
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() 호출");
        stopService(this.mBasicIntent);
        if (isService) {
            unbindService(conn);
        }
    }
}