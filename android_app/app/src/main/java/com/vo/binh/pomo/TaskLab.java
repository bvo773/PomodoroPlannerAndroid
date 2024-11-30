package com.vo.binh.pomo;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Singleton class for Model(Hosting data)
 */
public class TaskLab {

    private static TaskLab sTaskLab;
    private List<Task> mTasks;

    public static TaskLab get(Context context) {
        if (sTaskLab == null)
            sTaskLab = new TaskLab(context);
        return  sTaskLab;
    }

    private TaskLab(Context context) {
        mTasks = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            Task task = new Task();
            task.setTitle("Task #" + i);
            task.setCompleted(i%2 == 0);
            mTasks.add(task);
        }
    }

    public List<Task> getTasks() {
        return mTasks;
    }

    public Task getTask(UUID id) {
        for (Task task: mTasks) {
            if(task.getId() == id)
                return task;
        }
        return null;
    }
}
