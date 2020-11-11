package com.example.lifecycleex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // debug모드 로그
        Log.d("tag", "onCreate메서드 실행");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "onStart메서드 실행");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "onResume메서드 실행");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "onPause메서드 실행");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag", "onStop메서드 실행");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag", "onRestart메서드 실행");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "onDestroy메서드 실행");
    }

    public void viewActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}