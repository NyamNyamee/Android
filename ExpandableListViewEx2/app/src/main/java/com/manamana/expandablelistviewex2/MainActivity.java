package com.manamana.expandablelistviewex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> groupList = new ArrayList<>();
    Map<String, List<String>> childList = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1. 찾기
        expandableListView = findViewById(R.id.expandableListView);

        // 2. 데이터 준비
        Random rnd = new Random();
        for(int i=1;i<=rnd.nextInt(5)+2;i++){
            groupList.add(i+"번째 부모");
            List<String> child = new ArrayList<>();
            for(int j=1;j<=rnd.nextInt(8)+2;j++){
                child.add(i + "번째 부모의 " + j + "번째 자식");
            }
            childList.put(i+"번째 부모", child);
        }
        // 3. 어뎁터 준비
        MyAdapter adapter = new MyAdapter(this, groupList, childList);
        // 4. 어뎁터 붙이고
        expandableListView.setAdapter(adapter);
        // 5. 리스너 지정
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String data = childList.get(groupList.get(groupPosition)).get(childPosition);
                Toast.makeText(getBaseContext(),data,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
