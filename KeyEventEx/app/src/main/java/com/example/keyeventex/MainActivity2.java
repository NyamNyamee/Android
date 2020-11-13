package com.example.keyeventex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goBack(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", "구렁이");
        setResult(1, intent);
        finish();
    }

    // back버튼을 누르면 데이터를 가지고 넘어가지 않는다 (어떤키인지, 어떤이벤트인지)
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            goBack(null);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}