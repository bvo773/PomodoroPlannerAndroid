package com.vo.binh.pomo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TaskFragment extends Fragment {
    private CheckBox mCompletedCheckBox;
    private EditText mTaskTitleField;
    private Task mTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the Task object
        if (getArguments() != null) {
            // Use arguments to restore the Task object if passed
            mTask = (Task) getArguments().getSerializable("task");
        } else {
            mTask = new Task(); // Default Task object
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_task, container, false);

        // Setup the task title EditText
        mTaskTitleField = v.findViewById(R.id.task_title);
        mTaskTitleField.setText(mTask.getTitle());
        mTaskTitleField.addTextChangedListener(new TaskTitleWatcher());

        // Setup the completed CheckBox
        mCompletedCheckBox = v.findViewById(R.id.task_completed);
        mCompletedCheckBox.setChecked(mTask.isCompleted());
        mCompletedCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> mTask.setCompleted(isChecked));

        return v;
    }

    /**
     * A TextWatcher implementation to handle text changes for task title.
     */
    private class TaskTitleWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // No action needed
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            mTask.setTitle(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            // No action needed
        }
    }
}
