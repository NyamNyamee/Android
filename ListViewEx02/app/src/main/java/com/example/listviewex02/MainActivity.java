package com.example.listviewex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // 데이터를 담을 리스트(simple_list_item_2모양의 어댑터는 아래와 같은 형태로 데이터를 담아야 함)
    ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
    // 리스트를 담을 어댑터
    SimpleAdapter simpleAdapter;
    // 어댑터를 담을 리스트뷰
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        // 데이터 생성해 리스트에 담기
        for (int i = 1; i <= 50; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("item1", "나는 " + i + "번째 타이틀");
            map.put("item2", "나는 " + i + "번째 내용");
            list.add(map);
        }

        // 어댑터 지정(컨텍스트, 데이터, 모양, 맵의 키배열, 데이터의 표시형태를 지정하는 id의 숫자배열)
        simpleAdapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
                new String[]{"item1", "item2"},
                new int[]{android.R.id.text1, android.R.id.text2});
        
        // 어댑터 지정
        listView.setAdapter(simpleAdapter);
        

    }


}