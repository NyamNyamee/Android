package com.manamana.expandablerecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<MyAdapter.Item> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list.add(new MyAdapter.Item(MyAdapter.HEADER, "Fruits"));
        list.add(new MyAdapter.Item(MyAdapter.CHILD, "Apple"));
        list.add(new MyAdapter.Item(MyAdapter.CHILD, "Orange"));
        list.add(new MyAdapter.Item(MyAdapter.CHILD, "Banana"));

        MyAdapter.Item cars = new MyAdapter.Item(MyAdapter.HEADER, "Cars");
        cars.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Audi"));
        cars.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Aston Martin"));
        cars.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "BMW"));
        cars.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Cadillac"));
        list.add(cars);

        MyAdapter.Item places = new MyAdapter.Item(MyAdapter.HEADER, "Places");
        places.itemList = new ArrayList<>();
        places.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Kerala"));
        places.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Tamil Nadu"));
        places.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Karnataka"));
        places.itemList.add(new MyAdapter.Item(MyAdapter.CHILD, "Maharashtra"));
        list.add(places);

        recyclerView.setAdapter(new MyAdapter(list));

    }
}
