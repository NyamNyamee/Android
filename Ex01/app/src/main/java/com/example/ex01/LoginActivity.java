package com.example.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText idET, pwET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idET = findViewById(R.id.idET);
        pwET = findViewById(R.id.pwET);
    }

    public void moveToMain(View view) {
        Toast.makeText(this, "Move to main page", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    public void clearBtn(View view) {
        // Toast.makeText(this, idET.getText().toString() + " - " + pwET.getText().toString(), Toast.LENGTH_SHORT).show();
        idET.setText("");
        pwET.setText("");
    }

    // 앱이 일시정지될 때 값을 공유메모리에 저장해놓음
    @Override
    protected void onPause() {
        super.onPause();
        // myData라는 공유메모리 생성(내 앱에서만 접근가능하는 모드)
        SharedPreferences preferences = getSharedPreferences("myData", MODE_PRIVATE);
        // 공유영역을 편집하는 편집기 객체생성
        SharedPreferences.Editor editor = preferences.edit();
        // 편집기에 data라는 text데이터를 저장
        editor.putString("id", idET.getText().toString());
        editor.putString("pw", pwET.getText().toString());
        // 적용
        editor.commit();
    }

    // 앱을 다시 켰을 때 값을 불러와 작업

    @Override
    protected void onResume() {
        super.onResume();
        // myData라는 공유메모리 불러오기
        SharedPreferences preferences = getSharedPreferences("myData", MODE_PRIVATE);
        // 공유메모리영역에 id, pw라는 데이터가 존재한다면
        if (preferences != null && preferences.contains("id") && preferences.contains("pw")) {
            // 데이터(데이터, 기본값)를 읽어 editText에 저장
            String id = preferences.getString("id", "");
            String pw = preferences.getString("pw", "");
            idET.setText(id);
            pwET.setText(pw);
        }
    }

    // 로그인버튼 클릭시
    public void signIn(View view) {
        Boolean login = false;
        // 임시 로그인을 위해 아이디와 비밀번호가 같을 때에만 로그인하도록
        String id = idET.getText().toString();
        String pw = pwET.getText().toString();
        if (id.trim().length() == 0 || id == null || !id.equals(pw)) {
            // 실패시 로그인실패 토스트 출력
            Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
        } else {
            login = true;
            Toast.makeText(this, "Hello " + id + "~!", Toast.LENGTH_SHORT).show();
            Log.d("loginTag", id + "/" + pw + "/" + login);

            Intent intent = new Intent();
            intent.putExtra("login", login);
            setResult(1, intent);
            finish();
        }

    }
}