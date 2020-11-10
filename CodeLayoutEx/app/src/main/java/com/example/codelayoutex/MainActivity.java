package com.example.codelayoutex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        // 메인레이아웃 생성
        LinearLayout layout = new LinearLayout(this);
        // 붙일때 사용할 파라메터 생성
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        // 버튼 만들기
        Button button = new Button(this);
        // 버튼 제목지정
        button.setText("눌러봐!!!");
        // 이벤트 등록
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "뭐지?", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
        // 버튼을 메인레이아웃에 붙이기
        layout.addView(button, param);
        // 메인레이아웃을 액티비티에 붙이기
        setContentView(layout);
    }
}