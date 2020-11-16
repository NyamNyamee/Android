package com.manamana.tabex04;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    String[] titles = "하나,둘,셋,네엣,다섯,여섯,일곱,팔,아홉,열".split(",");
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position>titles.length/2) {
            return BlankFragment.newInstance(position+"번째 탭", titles[position] + "!!!!");
        }else{
            return BlankFragment2.newInstance(position+"번째 탭", titles[position] + "!!!!");
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override // 이놈을 만들어 주어야 타이틀이 보인다.
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
