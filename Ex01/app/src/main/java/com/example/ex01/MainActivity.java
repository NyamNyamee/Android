package com.example.ex01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
    }

    public void moveToMain(View view) {
        Toast.makeText(this, "Move to main page", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }

    public void moveToLogin(View view) {
        Toast.makeText(this, "Move to login page", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(this, LoginActivity.class);
        startActivityForResult(intent1, 1004);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1004:
                switch (resultCode) {
                    case 1:
                        Bundle bundle = data.getExtras();
                        boolean loginFlag = bundle.getBoolean("login");
                        // Log.d("loginTag", loginFlag + "");
                        if (loginFlag) {
                            loginBtn.setText("Logout");
                            if (loginBtn.getText().toString().equals("Logout")) {
                                loginBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        loginBtn.setText("Login");
                                    }
                                });
                            }
                        }
                        break;
                }
                break;
        }
    }

}