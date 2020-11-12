package com.example.smsex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";

    public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 문자를 받았을 때
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive() 메서드 호출됨.");

        // 받은 intent를 bundle에 저장
        Bundle bundle = intent.getExtras();
        // bundle의 내용을 smsMessage타입으로 변환해 배열에 저장
        SmsMessage[] messages = parseSmsMessage(bundle);
        // 배열에 내용이 존재한다면
        if (messages != null && messages.length > 0) {
            // 받은 메시지의 발신자를 저장
            String sender = messages[0].getOriginatingAddress();
            Log.i(TAG, "SMS sender : " + sender);
            // 받은 메시지의 내용 저장
            String contents = messages[0].getMessageBody();
            Log.i(TAG, "SMS contents : " + contents);
            // 받은 메시지의 날짜를 date타입으로 저장
            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.i(TAG, "SMS received date : " + receivedDate.toString());
            
            // 받은 내용들을 출력하기 위해 sendToActivity에 값 전달
            sendToActivity(context, sender, contents, receivedDate);
        }
    }

    // intent에 담긴 값을 저장한 bunlde객체에 저장된 문자메시지 정보를 해석하는 메서드
    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        // 파라미터로 받은 bundle의 내용을 object타입으로 변경하여 배열에 저장
        Object[] objs = (Object[]) bundle.get("pdus");

        int smsCount = objs.length;
        // 위에서 받은 objs배열의 크기와 같은 smsMessage타입의 배열 생성
        SmsMessage[] messages = new SmsMessage[smsCount];
        // obj에 담긴 내용을 smsMessage타입으로 변환하여 배열에 담음
        for (int i = 0; i < smsCount; i++) {
            // SDK가 마시멜로버전 이상이라면 format을 생성해 함께 전달해야함
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }
        // smsMessage타입으로 변환한 배열 리턴
        return messages;
    }

    // 문자의 내용들을 가지고 내용을 보여줄 액티비티를 띄우는 메서드
    private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
        Intent myIntent = new Intent(context, SmsActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("sender", sender);
        myIntent.putExtra("contents", contents);
        myIntent.putExtra("receivedDate", format.format(receivedDate));
        context.startActivity(myIntent);
    }

}
