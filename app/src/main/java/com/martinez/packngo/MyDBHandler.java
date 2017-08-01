package com.martinez.packngo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.martinez.packngo.data.Task;

/**
 * Created by Daniel Martinez on 7/23/2017.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    // Define database variables
    private static final String DATABASE_NAME = "tasklist.db";
    private static final int DATABASE_VERSION = 1;

    //Creating Task table
    public static final String TABLE_TASK = "task";
    public static final String TASK_ID = "_id";
    private static final int TASK_ID_COLUMN = 0;

    public static final String TASK_NAME = "task_name";
    private static final int TASK_NAME_COLUMN = 1;

    public static final String TASK_NOTES = "_idnotes";
    private static final int TASK_NOTES_COLUMN = 2;


    // Define SQLit database variables
    private SQLiteDatabase database;


    // Constructor
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Responsible for creating a table for the first time
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String createTask = "CREATE TABLE " + TABLE_TASK + "(" +
                TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TASK_NAME + " TEXT NOT NULL, " +
                TASK_NOTES + " TEXT NOT NULL);";
//        String createTask = "CREATE TABLE " + TABLE_TASK + "(" +
//                TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                TASK_NAME + " TEXT);";
        sqLiteDatabase.execSQL(createTask);

    }

    /**
     * Passing Task Object and putting TaskName into DB
     * @param task
     */
    public void insertTask(Task task){

        // Content value is built into android that allows you to add several values in one statement
        ContentValues values = new ContentValues();
        values.put(TASK_NAME, task.getTaskName());
        values.put(TASK_NAME, task.getNotes());

        // Call the open method to get reference to the database
        open();
        database.insert(TABLE_TASK, null, values);

        // Once you're done with database close it to give memory back (prevent memory leak)
        close();

    }

    // Responsible to making update to an existing table
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // Delete the entire table if it exits
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        // Recreate the table with the new properties
        onCreate(sqLiteDatabase);

    }

    public MyDBHandler open() throws SQLException {
        database = getWritableDatabase(); // get reference to the database
        return this;
    }
    public Cursor readEntry() {
        String[] allColumns = new String[] {TASK_ID, TASK_NAME};

        Cursor c = database.query(TABLE_TASK, allColumns, null, null, null, null, null);

        if(c != null)
        {
            c.moveToFirst();
        }
        return c;
    }
}