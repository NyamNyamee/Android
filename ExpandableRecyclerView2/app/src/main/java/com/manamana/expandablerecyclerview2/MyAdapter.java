package com.manamana.expandablerecyclerview2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // 데이터
    List<Item> list;

    // 생성자
    public MyAdapter(List<Item> list) {
        this.list = list;
    }

    // 뷰홀더
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mainTextView, subTextView;
        ImageView imageView;
        Item item;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mainTextView = itemView.findViewById(R.id.mainTV);
            mainTextView.setOnClickListener(this);
            subTextView = itemView.findViewById(R.id.subTV);
            subTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = (TextView) v;
                    Snackbar.make(v, textView.getText().toString(), Snackbar.LENGTH_SHORT).show();
                }
            });
            imageView = itemView.findViewById(R.id.mainIV);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // 현재가 아닌 것들의 자식은 모두 숨긴다.
            for (int i = 0; i < list.size(); i++) {
                Item item1 = list.get(i);
                if (!item.equals(item1) && item1.type == HEADER) {
                    int idx = list.indexOf(item1);
                    int count = 0;
                    while (list.size() > idx + 1 && list.get(idx + 1).type == CHILD) {
                        item1.itemList.add(list.remove(idx + 1));
                        count++;
                    }
                }
            }
            if (item.itemList.size() == 0) {
                int pos = list.indexOf(item);
                int count = 0;
                while (list.size() > pos + 1 && list.get(pos + 1).type == CHILD) {
                    item.itemList.add(list.remove(pos + 1));
                    count++;
                }
            } else {
                int pos = list.indexOf(item);
                int index = pos + 1;
                for (Item i : item.itemList) {
                    list.add(index, i);
                    index++;
                }
                item.itemList.clear();
            }
            notifyDataSetChanged(); // 데이터 변경 통지 : 다시 그리기!!!
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = list.get(position); // 데이터 얻기
        MyViewHolder myViewHolder = (MyViewHolder) holder; // 홀더 얻기
        myViewHolder.item = item; // 데이터를 홀더에 대입
        switch (item.type) {
            case HEADER:
                myViewHolder.imageView.setVisibility(View.VISIBLE);
                myViewHolder.mainTextView.setVisibility(View.VISIBLE);
                myViewHolder.subTextView.setVisibility(View.INVISIBLE);
                myViewHolder.mainTextView.setText(item.text);
                if (item.itemList.size() == 0) {
                    myViewHolder.imageView.setImageResource(R.drawable.remove_circle);
                } else {
                    myViewHolder.imageView.setImageResource(R.drawable.add_circle);
                }
                break;
            case CHILD:
                myViewHolder.imageView.setVisibility(View.INVISIBLE);
                myViewHolder.mainTextView.setVisibility(View.INVISIBLE);
                myViewHolder.subTextView.setVisibility(View.VISIBLE);
                myViewHolder.subTextView.setText(item.text);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // 데이터 저장 클래스
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    public static class Item {
        public int type;
        public String text;
        public List<Item> itemList = new ArrayList<>();

        public Item() {
        }

        public Item(int type, String text) {
            this.type = type;
            this.text = text;
        }
    }
}
