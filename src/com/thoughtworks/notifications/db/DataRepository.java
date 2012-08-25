package com.thoughtworks.notifications.db;

import android.content.Context;
import com.thoughtworks.notifications.model.Task;

import java.util.List;

public class DataRepository {
    private DbHelper dbHelper;

    public DataRepository(Context context) {
        dbHelper =   new DbHelper(context);
    }

    public void addTask(Task task) {
        dbHelper.insertTask(task);

    }

    public List<Task> fetchAllTasks() {
        return dbHelper.getAllTasks();
    }
}
