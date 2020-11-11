package com.example.senddataex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    private EditText editText;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        editText = findViewById(R.id.editText);

        // 데이터를 받아 editText객체의 힌트와 인풋타입을 속성을 지정
        Intent intent = getIntent();
        String hint = intent.getStringExtra("hint");
        type = intent.getStringExtra("type");

        editText.setHint(hint);
        if (type.equals("text")) {
            editText.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent();
        if (type.equals("text")) {
            String name = editText.getText().toString();
            intent.putExtra("name", name);
        } else {
            int age = 0; // age초기화
            try {
                age = Integer.parseInt(editText.getText().toString()); // 입력 값으로 지정
            } catch (Exception e) {

            }
            intent.putExtra("age", age);
        }
        setResult(1, intent);

        finish();
    }
}