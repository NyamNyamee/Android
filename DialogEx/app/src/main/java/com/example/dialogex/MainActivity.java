package com.example.dialogex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view) {
        // 다이얼로그 껍데기 지정
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("대화상자");
        builder.setMessage("종료고?");
        // android에 있는 리소스에서 아이콘을 가져와 아이콘지정
        builder.setIcon(android.R.drawable.ic_dialog_info);

        // 다이얼로그의 버튼 지정
        switch (view.getId()) {
            // which가 -3
            case R.id.btn3:
                builder.setNeutralButton("무시", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "무시무시" + which, Toast.LENGTH_SHORT).show();
                    }
                });

            case R.id.btn2:
                // which가 -2
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "무시무시" + which, Toast.LENGTH_SHORT).show();
                    }
                });

            case R.id.btn1:
                // which가 -1
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getBaseContext(), "무시무시" + which, Toast.LENGTH_SHORT).show();
                    }
                });

        }
        // 다이얼로그를 생성하고 띄우기
        builder.create().show();

        // 스낵바 만들고 누를시 이벤트 실행하는 액션까지 설정
        Snackbar.make(view, "스낵바메시지", BaseTransientBottomBar.LENGTH_LONG).setAction("눌러", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "왜눌러", Toast.LENGTH_LONG).show();
            }
        }).show();
    }
}