package com.example.webbrowserex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText urlET;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlET = findViewById(R.id.urlET);
        webView = findViewById(R.id.webView);

        // 웹뷰에 보여질 클라이언트 지정
        webView.setWebViewClient(new WebViewClient());

        // 브라우저를 크롬으로
        // webView.setWebChromeClient(new WebChromeClient());
    }

    // 인터넷 사용 권한을 manifest에서 설정해야한다
    public void goAddress(View view) {
        String url = urlET.getText().toString();
        // url로 이동
        webView.loadUrl(url);
    }
}