package com.thoughtworks.notifications;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.thoughtworks.notifications.NotificationsConstants.*;

public class MainTaskActivity extends ListActivity {

    ArrayList<String> items = new ArrayList<String>();
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String todo = (String) getListView().getItemAtPosition(position);
        Intent intent = new Intent(this, NewToDoActivity.class);
        intent.putExtra(TITLE_KEY, todo);
        startActivity(intent);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                items);

        // TODO loadfrom db
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

        items.add(0, taskTitleField.toString());
        listAdapter.notifyDataSetChanged();

        taskTitleField.clear();
    }

}