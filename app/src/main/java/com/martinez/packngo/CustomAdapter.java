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
    private MyDBHandler myDBHandler;

    public CustomAdapter(Context context, int resource, List<Task> taskObjects) {
        super(context, resource, taskObjects);
        this.context = context;
        this.taskObjects = taskObjects;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Task task =  taskObjects.get(position);
        myDBHandler = new MyDBHandler(getContext());

        // Inflating means reading the XML file that describes a layout
        // (or GUI element) and to create the actual objects that correspond to it,
        // and thus make the object visible within an Android app.

        // Passes an ID to get a handle on a system level service
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.fragment_item, null);

        // Referencing widgets from list view item row XML
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox);

        taskNameTV = (TextView) view.findViewById(R.id.taskName);
        taskNameTV.setText(task.getTaskName());

        myDBHandler.insertTask(task);

//         notes = (EditText) view.findViewById(R.id.notesET);

 /*       checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
*/
        return view;
    }

}