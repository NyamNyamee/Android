package com.example.gestureex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        gestureDetector = new GestureDetector(new GestureDetector.OnGestureListener() {
            // 눌렀을때
            @Override
            public boolean onDown(MotionEvent e) {
                textView.setText(textView.getText() + "\n" + "onDown");
                return false;
            }

            // 떼었을때
            @Override
            public void onShowPress(MotionEvent e) {
                textView.setText(textView.getText() + "\n" + "onShowPress");
            }

            // 화면이 한 손가락으로 눌렸다 떼어지는 경우
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                textView.setText(textView.getText() + "\n" + "onSingleTapUp");
                return false;
            }

            // 화면이 눌린 채 일정한 속도화 방향으로 움직였다 떼는 경우
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                textView.setText(textView.getText() + "\n" + "onScroll : " + distanceX + ", " + distanceY);
                return false;
            }

            // 길게 눌렀을 때
            @Override
            public void onLongPress(MotionEvent e) {
                textView.setText("");
            }

            // 화면이 눌린 채 가속도를 붙여 손가락을 움직였다 떼는 경우
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                textView.setText(textView.getText() + "\n" + "onFling : " + velocityX + ", " + velocityY);
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // gestureDetector가 있으면
        if (gestureDetector != null) {
            return gestureDetector.onTouchEvent(event); // 터치이벤트를 gestureDetector에 위임한다
        }
        return super.onTouchEvent(event);
    }
}