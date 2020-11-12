package com.example.serviceex01;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

// 서비스 클래스를 구현하려면, Service 를 상속받는다
public class MyService extends Service {
    MediaPlayer mediaPlayer; // 음악, 영상 재생을 위한 객체

    @Override
    public IBinder onBind(Intent intent) {
        // Service 객체와 (화면단 Activity 사이에서)
        // 통신(데이터를 주고받을) 때 사용하는 메서드
        // 데이터를 전달할 필요가 없으면 return null;
        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        Log.d("MyService", "서비스의 onCreate");
        mediaPlayer = MediaPlayer.create(this, R.raw.chacha);
        mediaPlayer.setLooping(false); // 반복재생 금지
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("MyService", "서비스의 onStartCommand");
        mediaPlayer.start(); // 음악 재생
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 서비스가 종료될 때 실행
        mediaPlayer.stop(); // 음악 종료
        Log.d("MyService", "서비스의 onDestroy");
    }
}

