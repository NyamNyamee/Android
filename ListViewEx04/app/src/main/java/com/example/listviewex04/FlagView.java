package com.example.listviewex04;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// 레이아웃 상속받기
public class FlagView extends LinearLayout {
    // 위젯변수 선언
    ImageView imageView;
    TextView textView;

    // Context와 VO를 받는 생성자 생성
    public FlagView(Context context, FlagVO vo) {
        super(context);

        // 인플레이터 생성 후 현재 클래스(레이아웃)에 붙임
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.flag_item, this, true);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        setFlagVO(vo);
    }

    // 데이터를 위젯에 세팅하는 메서드
    public void setFlagVO(FlagVO vo) {
        imageView.setImageResource(vo.getFlagID());
        textView.setText(vo.getFlagName());
    }
}
