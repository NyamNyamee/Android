package com.example.expandablelistviewex02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

// 상속받기
public class MyAdapter extends BaseExpandableListAdapter {
    // 변수 3개 선언
    List<String> parentList;
    HashMap<String, List<FlagVO>> childMap;
    LayoutInflater inflater;

    // context포함 파라미터 있는 생성자 생성
    public MyAdapter(Context context, List<String> parentList, HashMap<String, List<FlagVO>> childMap) {
        this.parentList = parentList;
        this.childMap = childMap;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // 메서드 오버라이딩
    // 부모개수
    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    // 자식개수
    @Override
    public int getChildrenCount(int groupPosition) {
        return childMap.get(parentList.get(groupPosition)).size();
    }

    // 부모 1개
    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    // 자식 1개
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childMap.get(parentList.get(groupPosition)).get(childPosition);
    }

    // 부모 인덱스
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    // 자식 인덱스
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    // 노건들
    @Override
    public boolean hasStableIds() {
        return false;
    }

    // 부모모양
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // 부모이름
        String parentTitle = parentList.get(groupPosition);
        // 컨버터뷰 설정
        if(convertView == null){
            convertView = inflater.inflate(R.layout.parent, null);
        }
        // 텍스트뷰 찾아 부모이름 지정
        TextView textView = convertView.findViewById(R.id.textView);
        textView.setText(parentTitle);
        
        return convertView;
    }

    // 자식모양
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        FlagVO flagVO = childMap.get(parentList.get(groupPosition)).get(childPosition);
        // 컨버터뷰 설정
        if(convertView == null){
            convertView = inflater.inflate(R.layout.child, null);
        }
        // 이미지뷰, 텍스트뷰 찾아 부모이름 지정
        ImageView iv = convertView.findViewById(R.id.iv);
        iv.setImageResource(flagVO.getFlagID());
        TextView tv = convertView.findViewById(R.id.tv);
        tv.setText(flagVO.getFlagName());
        return convertView;
    }

    // 자식선택가능여부
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
