package com.example.listviewex04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<FlagVO> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 찾기
        listView = findViewById(R.id.listView);

        // 데이터 생성
        List<String> flagName = new ArrayList<>();
        Scanner sc = new Scanner(getResources().openRawResource(R.raw.flag_names));
        while (sc.hasNextLine()) {
            flagName.add(sc.nextLine().trim());
        }
        sc.close();

        for (int i = 0; i < flagName.size(); i++) {
            FlagVO vo = new FlagVO();
            vo.setFlagID(R.drawable.flag_afghanistan + i);
            vo.setFlagName(flagName.get(i));

            list.add(vo);
        }
        // 만들어놓은 어댑터 붙이기
        FlagAdapter adapter = new FlagAdapter(this, list);
        listView.setAdapter(adapter);

        // 리스너 등록
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FlagVO vo = list.get(position);
                Toast.makeText(getBaseContext(), vo.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}