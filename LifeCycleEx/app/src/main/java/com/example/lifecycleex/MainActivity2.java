package com.example.lifecycleex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = findViewById(R.id.editText);
    }

    public void goBack(View view) {
        finish();
    }

    // 데이터 저장
    @Override
    protected void onPause() {
        super.onPause();
        // myData라는 공유메모리 생성(내 앱에서만 접근가능하는 모드)
        SharedPreferences preferences = getSharedPreferences("myData", MODE_PRIVATE);
        // 공유영역을 편집하는 편집기 객체생성
        SharedPreferences.Editor editor = preferences.edit();
        // 편집기에 data라는 text데이터를 저장
        editor.putString("data", editText.getText().toString());
        // 적용
        editor.commit();
    }

    // 데이터 복구
    @Override
    protected void onResume() {
        super.onResume();
        // myData라는 공유메모리 불러오기
        SharedPreferences preferences = getSharedPreferences("myData", MODE_PRIVATE);
        // 공유메모리영역에 data라는 데이터가 존재한다면
        if (preferences != null && preferences.contains("data")) {
            // 데이터(데이터, 기본값)를 읽어 editText에 저장
            String data =preferences.getString("data", "");
            editText.setText(data);
        }
    }
}