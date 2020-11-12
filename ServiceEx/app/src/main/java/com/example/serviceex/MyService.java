package com.example.serviceex;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service implements Runnable{
    private int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        // 쓰레드 시작
        new Thread(this).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void run() {
        while(true){
            try {
                Log.d("MyService", "서비스 호출 - " + ++count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Log.d("MyService", e.getMessage());
            }
        }
    }
}