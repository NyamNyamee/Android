package com.example.gridviewex02;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChunjaView extends LinearLayout {
    TextView textView1, textView2;

    public ChunjaView(Context context) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item, this, true);

        textView1 = findViewById(R.id.tv1);
        textView2 = findViewById(R.id.tv2);

    }

    public void setChunjaVO(ChunjaVO vo) {
        textView1.setText(vo.getH());
        textView2.setText(vo.getM());
    }


}
