package com.thoughtworks.notifications;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainTaskActivity extends ListActivity {

    ArrayList<String> items = new ArrayList<String>();
    private ArrayAdapter<String> listAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                items);

        // TODO load the items before this page is rendered
        setContentView(R.layout.main_task_layout);
        setListAdapter(listAdapter);

        //Button btnAddTask = (Button) findViewById(R.id.btnAddTask);



    }

    public void addTask(View view) {
        Editable taskTitleField = ((EditText) findViewById(R.id.txtTaskTitle)).getText();

        items.add(0,taskTitleField.toString());
        listAdapter.notifyDataSetChanged();

        taskTitleField.clear();
    }

}