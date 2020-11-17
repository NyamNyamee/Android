package com.example.listviewex03;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Chunja2View extends LinearLayout {
    // 1. 내용을 표시할 위젯들을 변수로 선언한다.
    TextView textView1, textView2, textView3;

    // 2. 컨텍스트와 데이터 1개를 받는 생성자를 만들어 준다.
    public Chunja2View(Context context, Chunja2VO vo) {
        super(context);
        // xml레이아웃을 읽어 레이아웃을 완성한다.
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item, this, true);
        // 위젯을 찾는다.
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        setChunja2VO(vo);
    }
    // 3. 위젯에 데이터를 넣는메서드 추가
    public void setChunja2VO(Chunja2VO vo) {
        // 위젯에 데이터를 넣는다.
        textView1.setText(vo.getH().charAt(0)+"");
        textView2.setText(vo.getH() + "(" + vo.getK() +")");
        textView3.setText(vo.getT());
    }

}
