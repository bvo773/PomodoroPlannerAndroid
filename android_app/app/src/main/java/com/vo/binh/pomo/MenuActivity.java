package com.vo.binh.pomo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuActivity extends AppCompatActivity {
    // Member Variables (Global)
    private CardView mCardView1, mCardView2, mCardView3, mCardView4;
    private TextView mTodayDateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mTodayDateText = findViewById(R.id.text_date);
        mTodayDateText.setText(getTodayDate());

        inflateCardViews();

        mCardView1.setOnClickListener(view -> {
            Intent pomodoroTimerActivity = new Intent(MenuActivity.this, PomodoroTimerActivity.class);
            startActivity(pomodoroTimerActivity);
        });

        mCardView2.setOnClickListener(view -> {
            Intent pomodoroPlannerActivity = new Intent(MenuActivity.this, TaskListActivity.class);
            startActivity(pomodoroPlannerActivity);
        });
    }

    private String getTodayDate() {
        Date date = new Date();
        return new SimpleDateFormat("MMMM dd, yyyy").format(date);
    }

    private void inflateCardViews() {
        mCardView1 = findViewById(R.id.card_view1);
        mCardView2 = findViewById(R.id.card_view2);
        mCardView3 = findViewById(R.id.card_view3);
        mCardView4 = findViewById(R.id.card_view4);
    }

    private void slideToRightAnimation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        mCardView1.startAnimation(animation);
        mCardView2.startAnimation(animation);
        mCardView3.startAnimation(animation);
        mCardView4.startAnimation(animation);
    }
}
