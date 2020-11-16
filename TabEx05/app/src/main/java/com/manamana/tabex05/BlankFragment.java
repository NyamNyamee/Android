package com.manamana.tabex05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

    String param;
    TextView textView;

    public static BlankFragment newInstance(String param) {
        BlankFragment fragment = new BlankFragment();
        fragment.param = param;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        textView = view.findViewById(R.id.tv);
        if(textView!=null) textView.setText(param);
        return view;
    }
}
