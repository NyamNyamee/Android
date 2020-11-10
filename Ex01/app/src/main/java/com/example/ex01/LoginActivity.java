package com.example.ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        Toast.makeText(this, idET.getText().toString() + " - " + pwET.getText().toString(), Toast.LENGTH_SHORT).show();
        idET.setText("");
        pwET.setText("");
    }
}