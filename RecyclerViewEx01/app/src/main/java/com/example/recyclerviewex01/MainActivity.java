package com.example.recyclerviewex01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> data;
    MyAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // 데이터 생성
        data = new ArrayList<>();
        data.add("큰제목1,제목에 대한 설명1");
        data.add("큰제목2,제목에 대한 설명2");
        data.add("큰제목3,제목에 대한 설명3");
        data.add("큰제목4,제목에 대한 설명4");
        data.add("큰제목5,제목에 대한 설명5");

        // 레이아웃매니저 지정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // 어댑터 생성
        adapter = new MyAdapter(data);

        // 어댑터 지정
        recyclerView.setAdapter(adapter);


    }
}