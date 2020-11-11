package com.example.senddataex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    private EditText nameET, ageET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        nameET = findViewById(R.id.nameET);
        ageET = findViewById(R.id.ageET);
    }

    public void goBack(View view) {
        int resultCode = 1;
        String name = nameET.getText().toString();
        int age = 0;

        // name이 비정상이면resultCode를 2로
        if (name == null || name.trim().length() == 0) {
            resultCode = 2;
            name = "";
        }
        // age가 비정상이면 resultCode를 3으로
        try {
            age = Integer.parseInt(ageET.getText().toString());
        } catch (Exception e) {
            resultCode = 3;
        }

        // 인텐트 생성
        Intent intent = new Intent();
        // 인텐트에 데이터 저장
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        // 데이터 보내기(결과코드, 인텐트)
        setResult(resultCode, intent);

        // 창 닫기
        finish();
    }
}