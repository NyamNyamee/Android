package com.example.slidingex01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Animation leftAnim;
    private Animation rightAnim;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 텍스트뷰 연결
        textView = findViewById(R.id.textView);
        // 애니메이션 지정
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left);
        leftAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                textView.setVisibility(View.VISIBLE);
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setText("close");
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                ;
            }
        });
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.right);
        rightAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                textView.setVisibility(View.INVISIBLE);
                button.setText("open");
                button.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                ;
            }
        });
        // 버튼 연결
        button = findViewById(R.id.button);
    }

    public void sliding(View view) {
        if (button.getText().toString().equals("open")) {
            textView.startAnimation(leftAnim);
        } else {
            textView.startAnimation(rightAnim);
        }
    }

    float downX, upX;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            downX = event.getX();
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            upX = event.getX();

            if(downX < upX){
                textView.startAnimation(rightAnim);
            } else if(downX >upX){
                textView.startAnimation(leftAnim);
            }
        }
        return super.onTouchEvent(event);
    }
}