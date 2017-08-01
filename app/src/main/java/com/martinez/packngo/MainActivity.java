package com.martinez.packngo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.martinez.packngo.data.Task;

public class MainActivity extends AppCompatActivity {

    // Declare Widgets
    private EditText notesET;
    private TextView taskNameTV;
    private Button saveButton;
    private SharedPreferences savedValues;
    private Task task;

    private MyDBHandler myDBHandler;
    SQLiteDatabase db;
    //private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDBHandler = new MyDBHandler(this);

        // Reference widgets
        taskNameTV = (TextView) findViewById(R.id.taskName);
        notesET = (EditText) findViewById(R.id.notesET);
        saveButton = (Button) findViewById(R.id.saveButton);

        // get SharedPreferences object
        savedValues = getSharedPreferences("SavedValues", MODE_PRIVATE);

    }


    public void displayClick(View view) {

        // Open up a new screen of task/notes
        Intent i = new Intent(this, DisplayDatabaseActivity.class);
        startActivity(i);
    }


//    @Override
//    protected void onPause() {
//
//        SharedPreferences.Editor editor = savedValues.edit();
//      //  editor.putString("notes", notesET.getText().toString());
//        editor.commit();
//
//        super.onPause();
//    }
//
//    @Override
//    protected void onResume() {
//
//        super.onResume();
//        String notes = savedValues.getString("notes", "");
////        notesET.setText(notes);
//    }

}
