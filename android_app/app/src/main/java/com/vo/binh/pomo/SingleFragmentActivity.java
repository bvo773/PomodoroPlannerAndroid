package com.vo.binh.pomo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_planner); // A

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container); // B FrameLayout that hosts the fragment

        if (fragment == null) {
            fragment = createFragment(); // C
            fm.beginTransaction() // D
                    .add(R.id.fragment_container, fragment) // E
                    .commit(); // F
        }
    }
}
