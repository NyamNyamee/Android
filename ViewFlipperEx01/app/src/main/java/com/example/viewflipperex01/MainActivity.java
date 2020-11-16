package com.example.viewflipperex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private ViewFlipper viewFlipper;
    private TextView textView;
    private int index = 0;
    private float downX, upX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper = findViewById(R.id.viewFlipper);
        textView = findViewById(R.id.textView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 화면을 눌렀을때
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            downX = event.getX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) { // // 화면을 뗐을때
            upX = event.getX();
            // 왼쪽으로밀었을때
            if (downX > upX) {
                ++index;
                if (index == 10) {
                    index = 0;
                }
                viewFlipper.showNext();
            } else if (downX < upX) { // 오른쪽으로밀었을때
                --index;
                if (index == -1) {
                    index = 9;
                }
                viewFlipper.showPrevious();
            }
            String text = "";
            for (int i = 0; i < 10; i++) {
                if (index == i) {
                    text += "★";
                } else {
                    text += "☆";
                }
            }
            textView.setText(text);
        }

        return super.onTouchEvent(event);
    }
}