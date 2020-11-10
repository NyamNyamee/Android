package com.example.scrollviewex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean image = true;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    public void changeImage(View view) {
        if(image){
            imageView.setImageResource(R.drawable.image02);
        }else{
            imageView.setImageResource(R.drawable.image01);
        }
        image = !image;
    }
}