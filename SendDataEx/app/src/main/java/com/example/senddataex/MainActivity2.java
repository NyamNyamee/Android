package com.example.senddataex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);

        // 인텐트 받기
        Intent intent = getIntent();
        // 인텐트에서 데이터 한개씩 얻기
        // String name = intent.getStringExtra("name");
        // int age = intent.getIntExtra("age", 0);
        
        // 인텐트에서 데이터를 번들에 담아 한번에 얻기
        Bundle bundle = intent.getExtras();
        // 얻은 번들에서 값을 얻기
        String name = bundle.getString("name");
        int age = bundle.getInt("age");

        // 받은 데이터 처리
        setTitle(name + "씨의 앱");
        textView.setText(name + " (" + age + " 세)");
    }

    public void goBack(View view) {
        finish();
    }
}