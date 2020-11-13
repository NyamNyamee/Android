package com.example.keyeventex;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent, 1004);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1004) {
            if (resultCode == 1) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            }
        }
    }
}