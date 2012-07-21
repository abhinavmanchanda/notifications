package com.thoughtworks.notifications;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.thoughtworks.notifications.model.Task;

import java.util.ArrayList;

import static com.thoughtworks.notifications.NotificationsConstants.*;

public class MainTaskActivity extends ListActivity {

    //TODO make ArrayList of Tasks OR use cursor adapter
    ArrayList<Task> items = new ArrayList<Task>();

    private ArrayAdapter<Task> listAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listAdapter = new ArrayAdapter<Task>(
                this, android.R.layout.simple_list_item_1, items);
        items.add(new Task("sample task"));
        items.add(new Task("delete me once u r comfortable"));

        // TODO load list from db
        setContentView(R.layout.main_task_layout);
        setListAdapter(listAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO sync list with db items
    }

    public void addTask(View view) {
        Editable taskTitleField = ((EditText) findViewById(R.id.txtTaskTitle)).getText();

        items.add(0, new Task(taskTitleField.toString()));
        listAdapter.notifyDataSetChanged();

        taskTitleField.clear();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Task currentTask = (Task) getListView().getItemAtPosition(position);
        Intent intent = new Intent(this, NewToDoActivity.class);
        intent.putExtra(TITLE_KEY, currentTask.getTitle()); // TODO pass id here instead of title
        startActivity(intent);
    }

}