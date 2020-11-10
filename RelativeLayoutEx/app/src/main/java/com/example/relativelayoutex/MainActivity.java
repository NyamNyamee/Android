package com.example.relativelayoutex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewLayout(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn1:
                intent = new Intent(this,MainActivity2.class);
                break;
            case R.id.btn2:
                intent = new Intent(this,MainActivity3.class);
                break;
            case R.id.btn3:
                intent = new Intent(this,MainActivity4.class);
                break;
        }
        startActivity(intent);
    }
}