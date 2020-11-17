package com.example.listviewex03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    List<ChunjaVO> chunjaVOList;
    List<Chunja2VO> chunja2VOList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. 찾고
        listView = findViewById(R.id.listView);

        // 2. 데이터 만들고
        // assets폴더의 json파일읽기
        Gson gson = new Gson();
        try {
            InputStreamReader isr = new InputStreamReader(getAssets().open("chunja.json"));
            chunjaVOList = gson.fromJson(isr, new TypeToken<List<ChunjaVO>>() {
            }.getType());
            Log.d("JSON", chunjaVOList.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // raw 폴더의 json파일읽기
        InputStreamReader isr = new InputStreamReader(getResources().openRawResource(R.raw.chunja2));
        chunja2VOList = gson.fromJson(isr, new TypeToken<List<Chunja2VO>>() {
        }.getType());
        Log.d("JSON", chunja2VOList.toString());

        // 3. 어뎁터 붙이고
        Chunja2Adapter adapter = new Chunja2Adapter(this, chunja2VOList);
        listView.setAdapter(adapter);
        // 4. 리스너 지정

    }
}