package com.example.orientationex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView.setTextSize(20.f);
    }

    // 화면방향전환을 감지하려면 manifest의 activity태그에 속성을 추가해야 함
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // 가로모드로 전환시
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            textView.setTextSize(40.f);
        }
        // 세로모드 전환시
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            textView.setTextSize(20.f);
        }
    }
}