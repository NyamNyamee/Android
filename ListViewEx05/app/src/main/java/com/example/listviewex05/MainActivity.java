package com.example.listviewex05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 입력창
    EditText editText;
    
    // 데이터를 담을 리스트
    List<String> list = new ArrayList<>();
    // 리스트를 담을 어댑터
    ArrayAdapter<String> adapter;
    // 어댑터를 담을 리스트뷰
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.item);
        
        // 리스트에 값 추가
        list.add("컴퓨터");
        list.add("프린터");
        list.add("모니터");

        // 어댑터 설정
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, list);
        // 리스트뷰에 어댑터 지정
        listView.setAdapter(adapter);
        // 리스트뷰 리스너
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position); // 선택 항목을 리스트에서 제거
                Log.d("DATA", list.toString());
                // 데이터가 변경되었음을 어댑터에게 알려 주어야 한다.
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }

    // 버튼을 눌렀을때 실행할 메서드
    public void addData(View view) {
        // 입력창의 내용을 담음
        String data = editText.getText().toString();
        // 리스트에 내용을 추가
        list.add(data);
        Log.d("DATA", list.toString());
        // 데이터가 변경되었음을 어댑터에게 알려 주어야 한다.
        adapter.notifyDataSetChanged();
        // 입력창 초기화
        editText.setText("");
        // 입력창에 포커스
        editText.requestFocus();
    }
}