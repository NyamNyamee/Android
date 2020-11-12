package com.example.smsex;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SmsActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        // 레이아웃 객체연결
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        Button button = findViewById(R.id.button);
        // 버튼 이벤트지정
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // sms리시버에서 받은 인텐트 저장
        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    // sms리시버에서 새 인텐트를 받았을 때
    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }

    // sms리시버에서 받은 인텐트를 가지고 처리할 내용
    private void processIntent(Intent intent) {
        // 인텐트가 존재한다면
        if (intent != null) {
            // 인텐트에서 값을 얻어와 저장
            String sender = intent.getStringExtra("sender");
            String contents = intent.getStringExtra("contents");
            String receivedDate = intent.getStringExtra("receivedDate");
            // editText에 출력
            editText.setText(sender);
            editText2.setText(contents);
            editText3.setText(receivedDate);
        }
    }

}