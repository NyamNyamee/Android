package com.manamana.tabex03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
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

        viewPager = findViewById(R.id.viewPager);
        MyPageViewAdapter adapter = new MyPageViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabLayout);

        // TabLayout과 ViewPager를 연결해준다.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    // viewPager에서 사용할 어뎁터 클래스를 만들어 주어야 한다.
    class MyPageViewAdapter extends FragmentPagerAdapter{

        public MyPageViewAdapter(FragmentManager fm) { // 데이터를 받으려면 인수를 추가
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            String[] data = "한놈,두식이,석삼,너구리,오징어,육개장,칠면조".split(",");
            if(position%2==0)
                return BlankFragment.newInstance(position+"번째 탭 선택", data[position]); // 탭에서 사용할 Fragment를 만들어서 리턴
            else
                return BlankFragment2.newInstance(position+"번째 탭 선택", data[position]); // 탭에서 사용할 Fragment를 만들어서 리턴
        }

        @Override
        public int getCount() {
            return 7; // 탭개수
        }
    }
}
