package com.example.expandablelistviewex02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListView eListView;
    // 부모
    List<String> parentList;
    // 자식
    HashMap<String, List<FlagVO>> childMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eListView = findViewById(R.id.eListview);

        // 부모 데이터 생성
        parentList = new ArrayList<>();
        parentList.add("아시아");
        parentList.add("아프리카");
        parentList.add("유럽");
        parentList.add("오세아니아");
        parentList.add("아메리카");

        // 자식 데이터 생성
        childMap = new HashMap<>();

        List<FlagVO> list1 = new ArrayList<>();
        list1.add(new FlagVO(R.drawable.flag_afghanistan, "afghanistan"));
        list1.add(new FlagVO(R.drawable.flag_antigua_and_barbuda, "antigua_and_barbuda"));
        list1.add(new FlagVO(R.drawable.flag_argentina, "argentina"));
        childMap.put(parentList.get(0), list1);

        List<FlagVO> list2 = new ArrayList<>();
        list2.add(new FlagVO(R.drawable.flag_armenia, "armenia"));
        list2.add(new FlagVO(R.drawable.flag_australia, "australia"));
        childMap.put(parentList.get(1), list2);

        List<FlagVO> list3 = new ArrayList<>();
        list3.add(new FlagVO(R.drawable.flag_austria, "austria"));
        list3.add(new FlagVO(R.drawable.flag_bahrain, "bahrain"));
        childMap.put(parentList.get(2), list3);

        List<FlagVO> list4 = new ArrayList<>();
        list4.add(new FlagVO(R.drawable.flag_barbados, "barbados"));
        childMap.put(parentList.get(3), list4);

        List<FlagVO> list5 = new ArrayList<>();
        list5.add(new FlagVO(R.drawable.flag_belgium, "belgium"));
        list5.add(new FlagVO(R.drawable.flag_belarus, "belarus"));
        childMap.put(parentList.get(4), list5);

        // 어댑터 지정, 붙이기
        MyAdapter adapter = new MyAdapter(this, parentList, childMap);
        eListView.setAdapter(adapter);

        // 자식 클릭시 실행할 리스너 지정
        eListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getBaseContext(), parentList.get(groupPosition) + " : " + childMap.get(parentList.get(groupPosition)).get(childPosition).getFlagName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}