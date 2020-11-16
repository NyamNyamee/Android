package com.example.menuex01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LinearLayout mainLayout;
    Button button1, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);

        // 컨텍스트 메뉴가 나타나려면 반드시 등록을 해주어야 한다.
        registerForContextMenu(button1);
        registerForContextMenu(button2);

    }

    
    // 1. 옵션메뉴 : 우측 상단의 메뉴 아이콘을 클릭해서 나타나는 메뉴
    //              2개의 메서드를 오버라이딩 해주어야 한다.
    @Override   // 메뉴를 만들어 주는 메서드
    public boolean onCreateOptionsMenu(Menu menu) {
        // XML리소스에서 메뉴를 읽어서 붙인다.
        getMenuInflater().inflate(R.menu.menu, menu);
        // 자바코드에서 메뉴를 추가가 가능하다!!! (itemid는 메뉴의 id, order는 메뉴에 표시될 아이템의 순서)
        menu.add(100,1,200,"배경색 빨강");
        menu.add(100,2,100,"배경색 파랑");
        menu.add(100,3,300,"게임 시작");
        // 서브 메뉴 만들어 메인메뉴에 붙이기
        SubMenu subMenu = menu.addSubMenu("오늘점심은?");
        subMenu.add(200, 101,0,"우동");
        subMenu.add(200, 102,0,"짜장");
        subMenu.add(200, 103,0,"짬뽕");
        subMenu.add(200, 104,0,"백반");

        return super.onCreateOptionsMenu(menu);
    }
    @Override // 메뉴를 선택했을때 실행되는 메서드
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                setTitle("첫번째 메뉴 선택");
                break;
            case R.id.menu2:
                setTitle("두번째 메뉴 선택");
                break;
            case R.id.menu3:
                setTitle("세번째 메뉴 선택");
                break;
            case 1:
                mainLayout.setBackgroundColor(Color.RED);
                break;
            case 2:
                mainLayout.setBackgroundColor(Color.BLUE);
                break;
            case 101: case 102: case 103: case 104:
                Toast.makeText(this,
                         item.getTitle() + "을 먹는구나!!",
                          Toast.LENGTH_SHORT).show();
                break;
            case 3:
                if(item.getTitle().equals("게임 시작")){
                    item.setTitle("게임 종료");
                }else{
                    item.setTitle("게임 시작");
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    // 2. 컨텍스트 메뉴 : 윈도우에서는 우측버튼 클릭시 나타나는 메뉴.
    //                  안드로이드에서는 길게 누룰때 나타나는 메뉴
    //                  두개의 메서드를 만들어 주고 메뉴를 등록해 주어야 한다.
    //                  registerForContextMenu(객체)로 등록한다.
    @Override // 메뉴 만들기
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()){
            case R.id.btn1:
                // XML
                getMenuInflater().inflate(R.menu.menu, menu);
                break;
            case R.id.btn2:
                // Code
                menu.add(111,201,1, "빨강 배경");
                menu.add(111,202,2, "파랑 배경");
                break;
        }
    }
    @Override // 메뉴 선택시 이벤트
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 201:
                mainLayout.setBackgroundColor(Color.RED);
                break;
            case 202:
                mainLayout.setBackgroundColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }

    // 팝업메뉴 : 클릭하면 나타나는 메뉴
    public void viewPopUp(View view){
        // 1. 팝업메뉴를 만든다.
        PopupMenu menu = new PopupMenu(this,view);
        // 2. 메뉴를 완성한다.
        getMenuInflater().inflate(R.menu.menu2, menu.getMenu());
        menu.getMenu().add(0,1,1,"녹색 배경");
        // 3. 메뉴 선택시 처리할 리스너 등록
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Toast.makeText(getApplicationContext(),menuItem.getTitle(),Toast.LENGTH_SHORT).show();
                // switch문으로 메뉴 처리!!!!
                switch (menuItem.getItemId()){
                    case R.id.menu4:
                        mainLayout.setBackgroundColor(Color.RED);
                        break;
                    case R.id.menu5:
                        mainLayout.setBackgroundColor(Color.BLUE);
                        break;
                    case 1:
                        mainLayout.setBackgroundColor(Color.GREEN);
                        break;
                }
                return false;
            }
        });
        // 4. 팝업메뉴를 보이게 한다.
        menu.show();
    }
}
