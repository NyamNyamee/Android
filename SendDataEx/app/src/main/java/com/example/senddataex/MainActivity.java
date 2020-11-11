package com.example.senddataex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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


    public void sendData(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                // 인텐트 생성하여 액티비티 지정
                Intent intent1 = new Intent(this, MainActivity2.class);
                // 인텐트에 데이터 저장
                intent1.putExtra("name", "한사람");
                intent1.putExtra("age", 27);
                // 인텐트 시작
                startActivity(intent1);
                break;
            case R.id.btn2:
                // 인텐트 생성하여 액티비티 지정
                Intent intent2 = new Intent(this, MainActivity3.class);
                // 데이터를 받기위해 액티비티 띄우기 (인텐트, 액티비티넘버)
                // 이 때 콜백함수 onActivityResult를 만들어야 함
                startActivityForResult(intent2, 1004);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(this, MainActivity4.class);
                intent3.putExtra("hint", "이름입력");
                intent3.putExtra("type", "text");
                startActivityForResult(intent3, 1005);
                break;
            case R.id.btn4:
                Intent intent4 = new Intent(this, MainActivity4.class);
                intent4.putExtra("hint", "나이입력");
                intent4.putExtra("type", "number");
                startActivityForResult(intent4, 1006);
                break;
            case R.id.btn5:
                // 인텐트 생성하여 액티비티 지정
                Intent intent5 = new Intent(this, MainActivity5.class);
                // 인텐트에 객체데이터 저장
                intent5.putExtra("data", new JavaSimpleData("한사람", 22, false));
                // 인텐트 시작
                startActivity(intent5);
                break;
            case R.id.btn6:
                // 인텐트 생성하여 액티비티 지정
                Intent intent6 = new Intent(this, MainActivity6.class);
                // 인텐트에 객체데이터 저장
                intent6.putExtra("data", new AndroidSimpleData("두사람", 27, false));
                // 인텐트 시작
                startActivity(intent6);
                break;
        }
    }

    @Override                      // 액티비티넘버, 결과코드, 인텐트
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1004:
                String message = "";
                switch (resultCode) {
                    case 1: // name과 age를 둘다 받았을때
                        Bundle bundle = data.getExtras();
                        String name = bundle.getString("name");
                        int age = bundle.getInt("age");
                        message = name + "(" + age + "세)";
                        break;

                    case 2: // age만 받았을때
                        message = data.getIntExtra("age", 0) + "세 입니다";
                        break;

                    case 3: // 아무것도 안받았을때
                        message = "정상적인 데이터를 받지 못했습니다요";
                        break;
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
                break;

            case 1005:
                String name = data.getStringExtra("name");
                Toast.makeText(this, name + "씨 하이요", Toast.LENGTH_SHORT).show();
                break;

            case 1006:
                int age = data.getIntExtra("age", 0);
                String message2 = age < 20 ? "애들은 가라" : "안녕하십니까 형님";
                Toast.makeText(this, message2, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}