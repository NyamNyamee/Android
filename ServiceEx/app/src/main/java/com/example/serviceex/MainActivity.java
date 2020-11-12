package com.example.serviceex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent serviceIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceIntent = new Intent(this, MyService.class);
    }

    // 서비스시작
    public void startService(View view) {
        startService(serviceIntent);
    }
    // 서비스종료
    public void stopService(View view) {
        stopService(serviceIntent);
    }
}