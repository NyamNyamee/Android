package com.example.serviceex01;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.annotation.Nullable;

/*
IntentService는 인텐트를 전달하여 서비스의 어떤 작업을 수행하는데 사용될 수 있습니다.
파일 다운로드나 업로드 등의 처리 시간이 긴 작업을 수행하는데 사용할 수 있습니다.
또한, 인텐트만 전달하면 되기 때문에 사용하기 간편합니다.
 */
// IntentService를 상속받음
public class MyIntentService extends IntentService {
    private String TAG = "MyIntentService";

    public MyIntentService() {
        super("MyIntentService");
        Log.d(TAG, "생성자 호출");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate 호출");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent 호출");
        Log.d(TAG, "받은 내용 :" + intent.getStringExtra("message"));
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "onHandleIntent 호출 : " + i + "회");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() 호출");
    }
}