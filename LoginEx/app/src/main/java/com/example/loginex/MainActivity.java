package com.example.loginex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText idET, passwordET;
    RadioButton radioButton;
    CheckBox    checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idET = findViewById(R.id.idET);
        passwordET = findViewById(R.id.passwordET);
        radioButton = findViewById(R.id.radio1);
        checkBox = findViewById(R.id.checkBtn);
    }

    public void getData(View view) {
        String message = idET.getText().toString() + "\n" + passwordET.getText().toString() + "\n";
        if(radioButton.isChecked()){
            message += "관리자\n";
        }else {
            message += "일반회원\n";
        }
        if(checkBox.isChecked()){
            message += "최고 관리자\n";
        }
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void clearData(View view) {
        idET.setText("");
        passwordET.setText("");
        idET.requestFocus(); // 포커스 위치시키기
    }
}