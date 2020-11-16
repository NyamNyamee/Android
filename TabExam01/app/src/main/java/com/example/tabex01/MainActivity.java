package com.example.tabex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        // 탭을 선택했을때 처리하는 리스터 지정
        // 안드로이드가 아니라 구글이라서 리스너등록시 addOn~Listener이다
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            // 선택
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                textView1.setText(tab.getText() + " 선택");
                textView2.setText(tab.getText() + " 선택");
                textView3.setText(tab.getText() + " 선택");
            }
            // 해제
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}