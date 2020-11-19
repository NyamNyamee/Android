package com.example.calenderex01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int year, month;
    TextView textView;
    GridView gridView1, gridView2;
    List<DateVO> dateList = new ArrayList<>();
    DateAdapter dateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("음력달력 Ver 0.9");
        
        // 현재연월 얻기
        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;

        textView = findViewById(R.id.titleTV);

        // gridView1 세팅
        gridView1 = findViewById(R.id.griView1);
        String[] weeks = "일,월,화,수,목,금,토".split(",");
        ArrayAdapter<String> weekAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, weeks);
        gridView1.setAdapter(weekAdapter);

        // gridView2 세팅
        gridView2 = findViewById(R.id.griView2);
        dateAdapter = new DateAdapter(this, dateList);
        gridView2.setAdapter(dateAdapter);

        setCalendar(null);
    }

    // 달력에서 연월 변경시
    public void setCalendar(View view) {
        // view가 넘어왔다면(달력에서 연월을 변경했다면)
        if (view != null) {
            switch (view.getId()) {
                case R.id.imageView1:
                    if (year > 1) year--;
                    break;
                case R.id.imageView2:
                    month--;
                    if (month == 0) {
                        month = 12;
                        if (year > 1) year--;
                    }
                    break;
                case R.id.imageView3:
                    month++;
                    if (month == 13) {
                        month = 1;
                        year++;
                    }
                    break;
                case R.id.imageView4:
                    year++;
                    break;
            }
        }
        // 최소 실행시
        textView.setText(String.format("%04d년 %02d월", year, month));
        // 안드로이드에서 네트워크에 접속하기 위해서는 반드시 쓰레드를 이용하여 접속해야 한다, 메니페스트에 인터넷 권한 추가도 필요
        new LunarTask().execute(String.format("?search_year=%04d&search_month=%02d", year, month));
    }

    // AsyncTask상속받기 - 쓰레드로 작동가능
    class LunarTask extends AsyncTask<String, Void, Void> {

        // 쓰레드로 작동되는 메서드
        @Override
        protected Void doInBackground(String... strings) {
            String urlAddress = "https://astro.kasi.re.kr/life/pageView/5" + strings[0];
            Document doc = null;
            dateList.clear();
            List<DateVO> list = new ArrayList<>();
            try {
                doc = Jsoup.connect(urlAddress).get();
                Elements dateElements = doc.select("table tbody tr");
                for (Element date : dateElements) {
                    DateVO vo = new DateVO();
                    vo.setSolar(date.select("td").get(0).text());
                    vo.setLunar(date.select("td").get(1).text());
                    vo.setGanji(date.select("td").get(2).text());
                    list.add(vo);
                    Log.d("date", vo.toString());
                }
                for (int i = 0; i < list.get(0).getSolarWeek(); i++) {
                    dateList.add(new DateVO("", "", ""));
                }
                for (DateVO vo : list) dateList.add(vo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dateAdapter.notifyDataSetChanged();
        }
    }
}
