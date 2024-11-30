package com.vo.binh.pomo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.fragment.app.Fragment;

/**
 * Controller class inherits TaskListFragment Controller
 */
public class TaskListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
}
