package com.martinez.packngo;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.martinez.packngo.data.Task;
import com.martinez.packngo.data.TaskData;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ItemFragment extends ListFragment {

    //  getting List of Task from TaskData Class
    List<Task> task = new TaskData().getTask();
    private SharedPreferences savedValues;
    private TextView taskNameTV;
    private EditText notesET;
    private Button saveButton;


    //Mandatory empty constructor for the fragment manager
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // creating the custom adapter and setting it
        CustomAdapter adapter = new CustomAdapter(getContext(), R.layout.fragment_item, task);
       setListAdapter(adapter);

        // Reference widgets
        taskNameTV = view.findViewById(R.id.taskName);
        notesET =  view.findViewById(R.id.notesET);
        saveButton = view.findViewById(R.id.saveButton);

        // get SharedPreferences object
        savedValues = getActivity().getSharedPreferences("SavedValues", MODE_PRIVATE);

        return view;
    }

    @Override
    public void onPause() {

        SharedPreferences.Editor editor = savedValues.edit();
        //editor.putString("notes", notesET.getText().toString());
        editor.commit();

        super.onPause();
    }

    @Override
    public void onResume() {

        super.onResume();
       // String notes = savedValues.getString("notes", "");
       // notesET.setText(notes);
    }

}
