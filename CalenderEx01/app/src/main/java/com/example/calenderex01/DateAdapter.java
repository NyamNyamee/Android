package com.example.calenderex01;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

// 상속
public class DateAdapter extends BaseAdapter {
    // 변수 두개
    Context context;
    List<DateVO> list;

    // 생성자
    public DateAdapter(Context context, List<DateVO> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // 뷰
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DateVO vo = list.get(position);
        // Log.d("date", vo.toString());
        DateView dateView = null;
        if(convertView==null) {
            dateView = new DateView(context, vo);
        }else{
            dateView = (DateView)convertView;
            dateView.setDateVO(vo);
        }
        return dateView;
    }
}
