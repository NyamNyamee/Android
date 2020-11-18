package com.example.recyclerviewex01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // 표시할 데이터
    private List<String> data = null;
    // 데이터를 받는 생성자 생성
    public MyAdapter(List<String> data) {
        this.data = data;
    }

    // RecyclerView.ViewHolder를 상속받는 내부클래스 생성
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1, textView2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    // 메서드 오버라이딩
    // 아이템뷰를 위한 뷰홀더 객체를 생성해 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 레이아웃 전개
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item, parent, false);
        MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(view);
        return vh;
    }

    // position에 대항하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 데이터 붙이기
        holder.textView1.setText(data.get(position).split(",")[0]);
        holder.textView2.setText(data.get(position).split(",")[1]);
    }

    // 데이터 개수
    @Override
    public int getItemCount() {
        return data.size();
    }
}
