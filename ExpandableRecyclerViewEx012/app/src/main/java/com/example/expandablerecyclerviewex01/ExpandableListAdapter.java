package com.example.expandablerecyclerviewex01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpandableListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // 부모인지 자식인지 구분하는 상수 선언
    public static final int HEADER = 0;
    public static final int CHILD = 1;

    // 데이터
    private List<Item> data;

    // 데이터를 받는 생성자 생성
    public ExpandableListAdapter(List<Item> data) {
        this.data = data;
    }

    // 레이아웃 전개
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        View view = null;
        Context context = parent.getContext();
        float dp = context.getResources().getDisplayMetrics().density;
        int subItemPaddingLeft = (int) (18 * dp);
        int subItemPaddingTopAndBottom = (int) (5 * dp);
        // 부모일때 자식일때 따로
        switch (type) {
            case HEADER:
                LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_header, parent, false);
                ListHeaderViewHolder header = new ListHeaderViewHolder(view);
                return header;
            case CHILD:
                TextView itemTextView = new TextView(context);
                itemTextView.setPadding(subItemPaddingLeft, subItemPaddingTopAndBottom, 0, subItemPaddingTopAndBottom);
                itemTextView.setTextColor(0x88000000);
                itemTextView.setLayoutParams(
                        new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                return new RecyclerView.ViewHolder(itemTextView) {
                };
        }
        return null;
    }

    // 데이터를 위젯에 지정
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Item item = data.get(position); // 데이터 찾고
        switch (item.type) {
            case HEADER: // 부모면
                final ListHeaderViewHolder itemController = (ListHeaderViewHolder) holder; // 부모 뷰를 가져와서
                itemController.refferalItem = item; // 데이터 대입
                itemController.header_title.setText(item.text); // 글자 변경
                if (item.invisibleChildren == null) { // 숨겨진 리스트가 없다면
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus); // 마이너스 이미지
                } else {
                    itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus); // 플러스 이미지
                }
                // 이미지를 클릭하면
                itemController.btn_expand_toggle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (item.invisibleChildren == null) {// 숨겨진 리스트가 없다면
                            // 원본 데이터에서 내 자식들을 숨겨진 리스트로 이동
                            item.invisibleChildren = new ArrayList<Item>();
                            int count = 0;
                            int pos = data.indexOf(itemController.refferalItem); // 현재 위치 찾고
                            // 다음부터 다음 부모가 나타날때까지 반복
                            while (data.size() > pos + 1 && data.get(pos + 1).type == CHILD) {
                                item.invisibleChildren.add(data.remove(pos + 1)); // 이동
                                count++;
                            }
                            notifyItemRangeRemoved(pos + 1, count); // 위치 변경 통지
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_plus); // 이미지 변경
                        } else {
                            // 숨겨진 리스트에 있는 데이터를 원본으로 이동
                            int pos = data.indexOf(itemController.refferalItem);
                            int index = pos + 1;
                            for (Item i : item.invisibleChildren) {
                                data.add(index, i);
                                index++;
                            }
                            notifyItemRangeInserted(pos + 1, index - pos - 1);
                            itemController.btn_expand_toggle.setImageResource(R.drawable.circle_minus);
                            item.invisibleChildren = null;
                        }
                    }
                });
                break;
            case CHILD:
                TextView itemTextView = (TextView) holder.itemView;
                itemTextView.setText(data.get(position).text);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).type;
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    // 데이터를 저장하는 내부 클래스 뷰홀더
    private static class ListHeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView header_title;       // 부모의 제목
        public ImageView btn_expand_toggle; // + , - 이미지
        public Item refferalItem; // 데이터를 저장하는 객체

        public ListHeaderViewHolder(View itemView) {
            super(itemView);
            header_title = (TextView) itemView.findViewById(R.id.header_title);
            btn_expand_toggle = (ImageView) itemView.findViewById(R.id.btn_expand_toggle);
        }
    }
    // 데이터VO 클래스
    public static class Item {
        public int type; // 부모(0), 자식(1) 구분
        public String text; // 텍스트 뷰에 보여줄 제목(부모)
        public List<Item> invisibleChildren; // 자식들!!!!

        public Item() {
        }

        public Item(int type, String text) {
            this.type = type;
            this.text = text;
        }
    }
}