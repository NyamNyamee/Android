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

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive() 메서드 호출됨.");

        Bundle bundle = intent.getExtras();
        SmsMessage[] messages = parseSmsMessage(bundle);
        if (messages != null && messages.length > 0) {
            String sender = messages[0].getOriginatingAddress();
            Log.i(TAG, "SMS sender : " + sender);

            String contents = messages[0].getMessageBody();
            Log.i(TAG, "SMS contents : " + contents);

            Date receivedDate = new Date(messages[0].getTimestampMillis());
            Log.i(TAG, "SMS received date : " + receivedDate.toString());
            
            // 문자를 보여줄 액티비티 띄우기
            sendToActivity(context, sender, contents, receivedDate);
        }
    }

    // intent에 담긴 값을 저장한 bunlde객체에 저장된 문자메시지 정보를 해석하는 메서드
    private SmsMessage[] parseSmsMessage(Bundle bundle) {
        // 문자메시지가 pdus로 전달됨
        Object[] objs = (Object[]) bundle.get("pdus");

        // 위에서 받은 objs배열을 문자메시지타입 배열로 저장
        SmsMessage[] messages = new SmsMessage[objs.length];
        int smsCount = objs.length;
        // 모든 문자를 smsMessage타입으로 변환하여 배열에 담음
        for (int i = 0; i < smsCount; i++) {
            // SDK가 마시멜로버전 이상이라면
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i], format);
            } else {
                messages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
            }
        }

        return messages;
    }

    // 문자의 결과를 보여줄 액티비티로 값을 전달하기
    private void sendToActivity(Context context, String sender, String contents, Date receivedDate) {
        Intent myIntent = new Intent(context, SmsActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        myIntent.putExtra("sender", sender);
        myIntent.putExtra("contents", contents);
        myIntent.putExtra("receivedDate", format.format(receivedDate));
        context.startActivity(myIntent);
    }

}
