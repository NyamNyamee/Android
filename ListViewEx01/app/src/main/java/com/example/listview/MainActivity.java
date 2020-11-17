package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // 데이터 생성
    String data[] = ("한놈, 두놈, 세놈, 네놈, 오놈, 육놈, 칠놈, 팔놈, 구놈, 십놈, " +
            "한놈, 두놈, 세놈, 네놈, 오놈, 육놈, 칠놈, 팔놈, 구놈, 십놈, " +
            "한놈, 두놈, 세놈, 네놈, 오놈, 육놈, 칠놈, 팔놈, 구놈, 십놈, " +
            "한놈, 두놈, 세놈, 네놈, 오놈, 육놈, 칠놈, 팔놈, 구놈, 십놈").split(", ");
    // 데이터를 담을 어댑터 생성
    ArrayAdapter<String> adapter;
    // 어댑터를 담을 리스트뷰 생성
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        // 리스트에서 몇개를 선택할 수 있는지 지정
        // listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // values/array.xml에 만든 배열을 data변수에 저장
        Resources resources = getResources();
        data = resources.getStringArray(R.array.array); // (R.파일명.배열name)

        // 리스트뷰에 넣을 내용을 담은 어댑터(대량의 데이터를 저장해 필요시마다 적당한 뷰를 만들어 리턴하는 클래스)
        // adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        // adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, data);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);

        // 리스트뷰 어댑터 지정
        listView.setAdapter(adapter);

        // 리스트뷰의 데이터를 클릭했을 때
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), data[position] + " 선택됨", Toast.LENGTH_SHORT).show();
            }
        });
    }


}