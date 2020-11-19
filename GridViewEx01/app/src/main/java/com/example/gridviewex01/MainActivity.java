package com.example.gridviewex01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    // 데이터를 담을 리스트
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        // list에 데이터 집어넣기
        for (int i = 1; i <= 20; i++) {
            list.add(String.format("데이터 %02d", i));
        }

        // 어댑터 설정
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_gallery_item, list);
        // 그리드뷰에 어댑터 지정
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, list.get(position) + " 선택", BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        });
    }
}
