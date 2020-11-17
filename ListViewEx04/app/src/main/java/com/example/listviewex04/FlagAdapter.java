package com.example.listviewex04;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

// BaseAdapter 상속받기
public class FlagAdapter extends BaseAdapter {
    // 두개 변수 선언
    Context context; // getView()에서 사용하기 위해
    List<FlagVO> list; // 데이터를 담기 위해

    // 위에 선언한 두개 변수를 받는 생성자 생성
    public FlagAdapter(Context context, List<FlagVO> list) {
        this.context = context;
        this.list = list;
    }

    // 실시간으로 추가되거나 변경되는 데이터라면
    public void setList(List<FlagVO> list) {
        this.list = list;
    }

    // 메서드 오버라이딩
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
        FlagView flagView = null;
        FlagVO vo = list.get(position);

        if (convertView == null) {
            flagView = new FlagView(context, vo);
        } else {
            flagView = (FlagView) convertView;
            flagView.setFlagVO(vo);
        }

        return flagView;
    }
}
