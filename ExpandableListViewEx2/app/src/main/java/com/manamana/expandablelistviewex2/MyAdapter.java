package com.manamana.expandablelistviewex2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class MyAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> groupList;
    Map<String, List<String>> childList;

    public MyAdapter(Context context, List<String> groupList, Map<String, List<String>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
    }

    @Override
    public int getGroupCount() { // 부모의 개수
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) { // 몇 번째 구룹의 자식의 개수
        return childList.get(groupList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) { // 몇번째 부모
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) { // 몇번째 부모의 몇번째 자식
        return childList.get(groupList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) { // 부모의 위치
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) { // 자식의 위치
        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // 부모 뷰를 만들어서 리턴
        String data = groupList.get(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group,null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.groupTV);
        textView.setText(data);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        // 자식뷰를 만들어서 리턴
        String data = childList.get(groupList.get(groupPosition)).get(childPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child,null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.childTV);
        textView.setText(data);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
