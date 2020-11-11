package com.example.inflaterex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레이아웃을 읽어 위젯들을 객체화함
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.layout);
        // linearLayout의 모든 요소 제거
        linearLayout.removeAllViews();
        // inflator생성
        inflater = getLayoutInflater();
        // inflate
        inflater.inflate(R.layout.layout1, linearLayout, true);
    }

    public void viewXML(View view) {
        // LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = getLayoutInflater();
        // linearLayout의 모든 요소 제거
        linearLayout.removeAllViews();

        switch (view.getId()) {
            case R.id.btn1:
                // layout1을 linearLayout에 갖다 붙여라
                inflater.inflate(R.layout.layout1, linearLayout, true);
                break;
            case R.id.btn2:
                inflater.inflate(R.layout.layout2, linearLayout, true);
                break;
            case R.id.btn3:
                inflater.inflate(R.layout.layout3, linearLayout, true);
                break;
        }
    }
}