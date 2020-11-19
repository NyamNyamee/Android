package com.example.expandablerecyclerviewex02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView            recyclerView;
    List<MyAdapter.ItemVO>    list;
    MyAdapter               adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        list = new ArrayList<>();
        list.add(new MyAdapter.ItemVO(MyAdapter.HEADER,"과일"));
        list.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"사과"));
        list.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"수박"));
        list.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"감귤"));
        list.add(new MyAdapter.ItemVO(MyAdapter.HEADER,"주류"));
        list.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"소주"));
        list.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"맥주"));
        list.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"막걸리"));

        MyAdapter.ItemVO itemVO = new MyAdapter.ItemVO(MyAdapter.HEADER,"안주");
        List<MyAdapter.ItemVO> list2 = new ArrayList<>();
        list2.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"새우깡"));
        list2.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"오징어"));
        list2.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"땅콩"));
        list2.add(new MyAdapter.ItemVO(MyAdapter.CHILD,"아무거나"));
        itemVO.itemList = list2;
        list.add(itemVO);

        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}