package com.example.gridviewex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    List<ChunjaVO> list;
    ChunjaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        // 데이터 지정
        Gson gson = new Gson();
        InputStreamReader isr = new InputStreamReader(getResources().openRawResource(R.raw.chunja));
        list = gson.fromJson(isr, new TypeToken<List<ChunjaVO>>(){}.getType());

        // 어댑터 설정
        adapter = new ChunjaAdapter(this, list);
        
        // 어댑터 지정
        gridView.setAdapter(adapter);
    }
}