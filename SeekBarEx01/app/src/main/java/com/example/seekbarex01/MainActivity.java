package com.example.seekbarex01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    SeekBar seekBar1, seekBar2, seekBar3;
    LinearLayout layout;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekbar1);
        seekBar1.setOnSeekBarChangeListener(this);

        seekBar2 = findViewById(R.id.seekbar2);
        seekBar2.setOnSeekBarChangeListener(this);

        seekBar3 = findViewById(R.id.seekbar3);
        seekBar3.setOnSeekBarChangeListener(this);

        layout = findViewById(R.id.layout);

        textView = findViewById(R.id.colorInfo);

        setBackGroundColor();
    }

    private void setBackGroundColor() {
        int red = seekBar1.getProgress();
        int green = seekBar2.getProgress();
        int blue = seekBar3.getProgress();

        textView.setText(red + ", " + green + ", " + blue);
        // textView.setText(String.format("RGB : (%d, %d, %d)", red, green, blue));
        layout.setBackgroundColor(Color.argb(200, red, green, blue));
    }

    // 시크바 값이 변경되었을때
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        setBackGroundColor();
    }

    // 시크바 조정이 시작되었을때
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    // 시크바 조정이 멈추었을때
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}