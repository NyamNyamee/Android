package com.manamana.tabex05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    class PagerAdapter extends FragmentPagerAdapter{
        String[] title = "한놈,두식이,석삼,너구리,오징어,육계장,칠면조,팔불출,구공탄,십장생".split(",");
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 현재는 모든 화면이 같다!!!!
            if(position%2==0)
                return BlankFragment.newInstance(title[position]);
            else
                return BlankFragment2.newInstance(title[position],"ㅎㅎㅎ");
        }

        @Override
        public int getCount() { // 탭의 개수
            return title.length;
        }

        @Nullable
        @Override // 제목 리턴
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
