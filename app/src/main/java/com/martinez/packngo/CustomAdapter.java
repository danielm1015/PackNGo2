package com.martinez.packngo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import com.martinez.packngo.data.Task;


/**
 * Created by Daniel Martinez on 7/22/2017.
 */

public class CustomAdapter extends ArrayAdapter<Task> {

    //defining variables
    private Context context;
    private List<Task> taskObjects;
    private EditText notes;
    private TextView taskNameTV;
    private CheckBox checkBox;

    public CustomAdapter(Context context, int resource, List<Task> taskObjects) {
        super(context, resource, taskObjects);
        this.context = context;
        this.taskObjects = taskObjects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get Task Object from Array of Objects
        Task task =  taskObjects.get(position);

        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_item, null);

        // Referencing widgets from list view item row XML
         checkBox = view.findViewById(R.id.checkBox);

        taskNameTV = view.findViewById(R.id.taskName);
        taskNameTV.setText(task.getTaskName());

       // notes = view.findViewById(R.id.notesET);


   /*    checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        return view;
    }

}