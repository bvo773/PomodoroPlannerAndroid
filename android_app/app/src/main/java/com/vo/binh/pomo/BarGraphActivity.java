package com.vo.binh.pomo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;

public class BarGraphActivity extends AppCompatActivity {

    private BarChart mBarChart;
    private TextView tvX, tvY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargraph);

        // Initialize views
        mBarChart = findViewById(R.id.bar_chart);
        tvX = findViewById(R.id.text_view_x);
        tvY = findViewById(R.id.text_view_y);

        // Additional setup for the BarChart can be added here
    }
}
