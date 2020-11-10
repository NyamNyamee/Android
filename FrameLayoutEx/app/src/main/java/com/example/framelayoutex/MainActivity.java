package com.example.framelayoutex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView[] imageViews = new ImageView[10]; // 이미지뷰 10개
    private int index = 0; //현재 이미지번호
    private FrameLayout frameLayout; // 이미지를 담을 레이아웃
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        for(int i=0;i<imageViews.length;i++){
            imageViews[i] = new ImageView(this); // 이미지뷰 생성
            imageViews[i].setImageResource(R.drawable.game_title_01 + i); // 이미지뷰에 이미지 할당
            imageViews[i].setVisibility(View.INVISIBLE); // 숨기기
            frameLayout.addView(imageViews[i]); // 프레임레이아웃에 추가
        }
        imageViews[index].setVisibility(View.VISIBLE); // 첫번째 그림만 보이게하기
    }

    public void changeImage(View view) {
        imageViews[index].setVisibility(View.INVISIBLE); // 현재 이미지 숨기고
        index = ++index%imageViews.length; // 다음이미지 인덱스 선택
        imageViews[index].setVisibility(View.VISIBLE); // 보이기
    }
}