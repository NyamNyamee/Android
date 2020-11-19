package com.example.gridviewex02;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

// 상속받기
public class ChunjaAdapter extends BaseAdapter {
    // 변수두개선언
    Context context;
    List<ChunjaVO> list;

    // 생성자
    public ChunjaAdapter(Context context, List<ChunjaVO> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChunjaView chunjaView = null;
        ChunjaVO vo = list.get(position);

        // convertView가 없으면 chunjaView생성
        if (convertView == null) {
            chunjaView = new ChunjaView(context);
        } else { // 있으면 convertView대입
            chunjaView = (ChunjaView) convertView;
        }
        chunjaView.setChunjaVO(vo);

        return chunjaView;
    }
}
