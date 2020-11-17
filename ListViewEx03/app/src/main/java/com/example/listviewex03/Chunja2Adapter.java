package com.example.listviewex03;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

// 1. BaseAdapter를 상속받아 4개의 메서드를 오버라이딩 한다.
public class Chunja2Adapter extends BaseAdapter {
    // 2. 두개의 변수를 선언한다.
    Context context;
    List<Chunja2VO> list;
    // 3. 두개의 변수를 인수로 받는 생성자를 만들어 준다.
    public Chunja2Adapter(Context context, List<Chunja2VO> list) {
        this.context = context;
        this.list = list;
    }
    // 4. 혹시라도 실시간으로 데이터가 변경된다면 데이터를 추가하거나 변경하는 메서드를 추가한다.
    public void setList(List<Chunja2VO> list) { // 데이터를 변경하는 메서드
        this.list = list;
    }
    public void addChunja2VO(Chunja2VO vo){ // 데이터를 추가하는 메서드
        list.add(vo);
    }
    // 5. 만들어 놓은 4개의 메서드를 오버라이딩한다.
    @Override
    public int getCount() { // 데이터의 갯수를 리턴하도록한다.
        return list.size();
    }

    @Override
    public Object getItem(int position) { // 데이터1개를 리턴하도록 만든다.
        return list.get(position);
    }

    @Override
    public long getItemId(int position) { // 넘어온 위치를 리턴하도록 만든다.
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // 뷰를 만들어서 리턴한다.
        // 첫번째 인수는 데이터의 위치
        // 두번째 인수가 이미 만들어져 사용중인 객체이다.
        Chunja2View chunja2View=null;
        Chunja2VO vo = list.get(position);
        if(convertView==null){ // 없으면 만들고
            chunja2View = new Chunja2View(context, vo);
        }else{ // 있으면 재활용한다.
            chunja2View = (Chunja2View)convertView;
            chunja2View.setChunja2VO(vo);
        }
        return chunja2View;
    }
}
