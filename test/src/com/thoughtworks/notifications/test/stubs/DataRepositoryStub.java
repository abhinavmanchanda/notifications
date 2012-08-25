package com.thoughtworks.notifications.test.stubs;

import android.content.Context;
import com.thoughtworks.notifications.db.DataRepository;
import com.thoughtworks.notifications.model.Task;

import java.util.ArrayList;
import java.util.List;


public class DataRepositoryStub extends DataRepository{
    List<Task> taskList = new ArrayList<Task>();
    public DataRepositoryStub(Context context) {
        super(context);
    }

    @Override
    public void addTask(Task task) {
        taskList.add(task);
    }

    @Override
    public List<Task> fetchAllTasks() {
        return taskList;
    }
}
