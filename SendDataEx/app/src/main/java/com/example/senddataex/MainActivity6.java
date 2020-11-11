package com.example.senddataex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        textView = findViewById(R.id.textView);

        // 인텐트 받기
        Intent intent = getIntent();

        // Parcelable로 직렬화된 안드로이드객체얻기
        AndroidSimpleData data = intent.getParcelableExtra("data");
        // 객체 내용을 텍스트뷰에 지정
        textView.setText(data.toString());

    }

    public void goBack(View view) {
        finish();
    }
}