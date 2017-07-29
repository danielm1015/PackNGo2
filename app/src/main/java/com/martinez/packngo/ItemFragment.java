package com.martinez.packngo;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.martinez.packngo.data.Task;
import com.martinez.packngo.data.TaskData;

import java.util.List;

public class ItemFragment extends ListFragment {

    //  getting List of Task from TaskData Class
    List<Task> task = new TaskData().getTask();
    /**
     * Mandatory empty constructor for the fragment manager
     */
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

        return view;
    }


}
