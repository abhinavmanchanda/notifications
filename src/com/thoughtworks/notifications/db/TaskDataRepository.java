package com.thoughtworks.notifications.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TaskDataRepository extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "taskList";
    private static final String DATABASE_CREATE = "create table "+ TABLE_NAME + "";

    public TaskDataRepository(Context context) {
        super(context, "taskData", null, 1);
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
