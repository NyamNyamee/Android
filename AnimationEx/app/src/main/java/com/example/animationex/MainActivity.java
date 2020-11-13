package com.example.animationex;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button animBtn;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        animBtn = findViewById(R.id.animBtn);

        // 애니메이션 읽기
        animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        // 리스너 시작
        animation.setAnimationListener(new Animation.AnimationListener() {
            // 애니메이션 시작시
            @Override
            public void onAnimationStart(Animation animation) {
                animBtn.setEnabled(false); // 버튼 비활성화
            }

            // 애니메이션 종료시
            @Override
            public void onAnimationEnd(Animation animation) {
                animBtn.setEnabled(true); // 버튼 활성화
            }

            // 애니메이션 반복시
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void startAnim(View view) {
        textView.startAnimation(animation);
    }

}

