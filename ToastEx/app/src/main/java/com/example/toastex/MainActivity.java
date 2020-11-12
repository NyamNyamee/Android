package com.example.toastex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText offsetX, offsetY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ToastControl");

        offsetX = findViewById(R.id.offsetX);
        offsetY = findViewById(R.id.offsetY);
    }

    public void showToast(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                // 좌표 초기화
                int x = 0, y = 0;
                try {
                    // 입력값을 숫자로 변환 성공시 좌표값 저장
                    x = Integer.parseInt(offsetX.getText().toString());
                    y = Integer.parseInt(offsetY.getText().toString());
                } catch (Exception e) {

                }
                // 텍스트 뷰 생성
                TextView textView0 = new TextView(this);
                textView0.setText("나의 모양은?");
                textView0.setPadding(30, 30, 30, 30);
                textView0.setBackgroundColor(Color.argb(55, 255, 0, 0));
                // 토스트에 텍스트 지정
                Toast toast = new Toast(this);
                toast.setView(textView0);
                // 정 중앙을 기준으로 x, y좌표만큼 이동시킴
                toast.setGravity(Gravity.CENTER, x, y);
                toast.show();
                break;
            case R.id.btn2:
                // 텍스트 생성
                TextView textView = new TextView(this);
                textView.setText("나의 모양은?");
                textView.setPadding(30, 30, 30, 30);
                // 텍스트의 배경 지정
                textView.setBackgroundResource(R.drawable.bg);
                // 토스트에 텍스트 지정
                Toast toast1 = new Toast(this);
                toast1.setView(textView);
                toast1.show();
                break;
            case R.id.btn3:
                // 이미지 생성
                ImageView imageView = new ImageView(this);
                // 이미지 지정
                imageView.setImageResource(R.drawable.androidmon);
                // 토스트에 이미지 지정
                Toast toast2 = new Toast(this);
                toast2.setView(imageView);
                toast2.show();
                break;
        }
    }
}