package com.example.calenderex01;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DateView extends LinearLayout {
    TextView solarTV, lunarTV, ganjiTV;

    public DateView(Context context, DateVO dateVO) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.date, this);

        solarTV = findViewById(R.id.solarTV);
        lunarTV = findViewById(R.id.lunarTV);
        ganjiTV = findViewById(R.id.ganjiTV);
        // Log.d("date", dateVO.toString());

        setDateVO(dateVO);
    }

    public void setDateVO(DateVO dateVO) {
        if (!dateVO.getSolar().equals("")) {
            solarTV.setText(dateVO.getSolarDate());
            // 평일,토,일에 따라 글자 색상변경
            if (dateVO.getSolarWeek() == 6) {
                solarTV.setTextColor(Color.BLUE);
            } else if (dateVO.getSolarWeek() == 0) {
                solarTV.setTextColor(Color.RED);
            } else {
                solarTV.setTextColor(Color.BLACK);
            }

            lunarTV.setText(dateVO.getLunarMonth() + "-" + dateVO.getLunarDate());

            ganjiTV.setText(dateVO.getGanjiDateKor());
        } else {
            solarTV.setText("");
            lunarTV.setText("");
            ganjiTV.setText("");
        }
    }
}
