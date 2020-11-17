package com.example.bitmapbuttonex01;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(@NonNull Context context) {
        super(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) { // 버튼 누르면
            setBackgroundResource(R.drawable.bitmap_button_clicked);
        } else if (event.getAction() == MotionEvent.ACTION_UP) { // 버튼 떼면
            setBackgroundResource(R.drawable.bitmap_button_normal);
        }
        return super.onTouchEvent(event);
    }
}
