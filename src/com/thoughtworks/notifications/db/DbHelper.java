package com.thoughtworks.notifications.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.thoughtworks.notifications.R;
import com.thoughtworks.notifications.model.Task;

import java.util.ArrayList;
import java.util.List;

import static android.provider.BaseColumns._ID;

public class DbHelper extends SQLiteOpenHelper{


    private static final String TABLE_NAME = "task_list";
    private static final String NAME_COL = "name";
    private static final String DESCRIPTION_COL = "description";
    private static final String DB_NAME = "task_data.db";

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  NAME_COL
                    + " TEXT NOT NULL ," + DESCRIPTION_COL + " TEXT );";


    public DbHelper(Context context) {
        super(context, DB_NAME, null, Integer.parseInt(context.getString(R.string.db_version)));
    }

    public void insertTask(Task task){
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement("insert into "+TABLE_NAME+
                        " (" + NAME_COL +  ") values ( ? )");
        stmt.bindString(1, task.getName());
        stmt.executeInsert();
    }

    public List<Task> getAllTasks(){
        Cursor cursor = getReadableDatabase().query(TABLE_NAME, new String[]{_ID, NAME_COL, DESCRIPTION_COL}, null, null, null, null, null);
        List<Task> taskList = new ArrayList<Task>();
        while (cursor.moveToNext()){
            long id = cursor.getLong(0);
            String name = cursor.getString(1);
            String description = cursor.getString(2);
            taskList.add(new Task(id, name, description));
        }
        return taskList;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
