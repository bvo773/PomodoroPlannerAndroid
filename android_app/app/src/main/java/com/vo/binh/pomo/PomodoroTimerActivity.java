package com.vo.binh.pomo;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Locale;

public class PomodoroTimerActivity extends AppCompatActivity {
    private static final String TAG = "PomodoroTimerActivity";

    private static final long INTERVAL25MINS_IN_MILLIS = 1500000; // 25 minutes
    private TextView mCountDownTextview;
    private Button mStartPauseButton;
    private Button mResetButton;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = INTERVAL25MINS_IN_MILLIS;
    private CardView mGuideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro_timer);

        // Initialize views
        mCountDownTextview = findViewById(R.id.countdown_textview);
        mStartPauseButton = findViewById(R.id.start_pause_button);
        mResetButton = findViewById(R.id.reset_button);
        mGuideButton = findViewById(R.id.guide);

        // Guide button click listener
        mGuideButton.setOnClickListener(v -> {
            Intent intent = new Intent(PomodoroTimerActivity.this, GuideActivity.class);
            startActivity(intent);
        });

        // Start/pause button click listener
        mStartPauseButton.setOnClickListener(view -> {
            if (mTimerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        // Reset button click listener
        mResetButton.setOnClickListener(view -> resetTimer());

        // Update initial countdown text
        updateCountDownText();
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mStartPauseButton.setText("Start");
                mStartPauseButton.setVisibility(View.INVISIBLE);
                mResetButton.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mStartPauseButton.setText("Pause");
        mResetButton.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mStartPauseButton.setText("Start");
        mResetButton.setVisibility(View.VISIBLE);
        mStartPauseButton.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = INTERVAL25MINS_IN_MILLIS;
        updateCountDownText();
        mResetButton.setVisibility(View.INVISIBLE);
        mStartPauseButton.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000 / 60);
        int seconds = (int) (mTimeLeftInMillis / 1000 % 60);
        String timeLeftFormatted = String.format(Locale.getDefault(), "%d:%02d", minutes, seconds);
        mCountDownTextview.setText(timeLeftFormatted);
    }
}
