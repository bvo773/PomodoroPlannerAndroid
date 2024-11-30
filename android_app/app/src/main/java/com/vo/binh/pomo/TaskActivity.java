package com.vo.binh.pomo;

import androidx.fragment.app.Fragment;

import android.widget.CalendarView;

public class TaskActivity extends SingleFragmentActivity {

    private static final String TAG = "TaskActivity";
    private CalendarView mCalendarView;

    @Override
    protected Fragment createFragment() {
        return new TaskFragment();
    }
}
