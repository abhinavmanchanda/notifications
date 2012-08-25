package com.thoughtworks.notifications;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.thoughtworks.notifications.db.DataRepository;
import com.thoughtworks.notifications.model.Task;

import java.util.ArrayList;
import java.util.List;

import static com.thoughtworks.notifications.NotificationsConstants.*;

public class MainTaskActivity extends ListActivity {

    //TODO make ArrayList of Tasks OR use cursor adapter
    ArrayList<Task> items = new ArrayList<Task>();
    DataRepository dataRepository;

    private ArrayAdapter<Task> listAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataRepository = new DataRepository(this);
        listAdapter = new ArrayAdapter<Task>(
                this, android.R.layout.simple_list_item_1, items);
//        items.add(new Task("sample task"));
//        items.add(new Task("delete me once u r comfortable"));

        // TODO load list from db
        setContentView(R.layout.main_task_layout);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshList();
    }

    public void addTask(View view) {
        Editable taskTitleField = ((EditText) findViewById(R.id.txtTaskTitle)).getText();
        String name = taskTitleField.toString();
        taskTitleField.clear();

        Task task = new Task(name);
        addToDatabase(task);
        refreshList();
    }

    private void refreshList() {
        List<Task> taskList = dataRepository.fetchAllTasks();
        items.clear();
        items.addAll(taskList);
        listAdapter.notifyDataSetChanged();
    }

    private void addToDatabase(Task task) {
        dataRepository.addTask(task);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Task currentTask = (Task) getListView().getItemAtPosition(position);
        Intent intent = new Intent(this, NewToDoActivity.class);
        intent.putExtra(TITLE_KEY, currentTask.getName()); // TODO pass id here instead of title
        startActivity(intent);
    }

    public void setDataRepository(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}