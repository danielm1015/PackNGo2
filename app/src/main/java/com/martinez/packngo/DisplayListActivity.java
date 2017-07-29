package com.martinez.packngo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class DisplayListActivity extends AppCompatActivity {

        // Define the widget variable layout
        private TableLayout tableLayout;

        // Define  SQL controller variable
        MyDBHandler myDBHandler;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display_list);

            // Navigate back to parent class
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            // Get reference to the layout widget
            tableLayout = (TableLayout) findViewById(R.id.activity_test);

            // Instantiate the handler constructor
            myDBHandler = new MyDBHandler(this);

            // call the build table method
            BuildTable();
        }

        // Responsible for building table
        private void BuildTable() {
            myDBHandler.open();
            Cursor c =  myDBHandler.readEntry();

            int rows = c.getCount();
            int cols = c.getColumnCount();

            c.moveToFirst();

            // Outer for loop
            for(int i = 0; i < rows; i++)
            {
                TableRow row = new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));

                // Inner loop
                for(int j = 0; j < cols; j++)
                {
                    TextView tv = new TextView(this);
                    tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextSize(18);
                    tv.setPadding(0, 5, 0, 5);

                    tv.setText(c.getString(j));

                    row.addView(tv);
                }

                c.moveToNext();
                tableLayout.addView(row);
            }

            // Close the database
            myDBHandler.close();
        }
    }
