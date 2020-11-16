package com.example.progressbarex01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        // 프로그래스바를 움직여 보자
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (value <= progressBar.getMax()) {
                    ++value;
                    progressBar.setProgress(value);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void viewProgress(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                ProgressDialog dialog1 = new ProgressDialog(this);
                // dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); 막대프로그레스바 지정
                dialog1.setTitle("다운로드중");
                dialog1.setMessage("현재 다운로드 중입니다.");
                dialog1.setMax(100);
                dialog1.setProgress(0);
                // 실제 작업할 코드
                new Thread(new Runnable() {
                    int value = 0;

                    @Override
                    public void run() {
                        while (value <= dialog1.getMax()) {
                            ++value;
                            dialog1.setProgress(value);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        dialog1.dismiss(); // 닫기
                    }
                }).start();
                dialog1.show();
                break;
            case R.id.btn2:
                ProgressDialog dialog2 = new ProgressDialog(this);
                dialog2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog2.setTitle("다운로드중");
                dialog2.setMessage("현재 다운로드 중입니다.");
                dialog2.setMax(100);
                dialog2.setProgress(0);
                new Thread(new Runnable() {
                    int value = 0;

                    @Override
                    public void run() {
                        while (value <= dialog2.getMax()) {
                            ++value;
                            dialog2.setProgress(value);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        dialog2.dismiss(); // 닫기
                    }
                }).start();
                dialog2.show();
                break;
        }

    }
}