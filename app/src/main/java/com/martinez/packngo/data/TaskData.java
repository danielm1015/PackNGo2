package com.martinez.packngo.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Martinez on 7/22/2017.
 */

public class TaskData {

    // Array of Tasks
    private List<Task> task = new ArrayList<Task>();

    // getting the List of tasks
    public List<Task> getTask() {
        return task;
    }

    public TaskData() {
        addItem(new Task("Tent"));
        /*addItem(new Task("Food", "Notes"));
        addItem(new Task("Money", "Notes"));
        addItem(new Task("Sleeping bag", "Notes"));*/

    }

    private void addItem(Task item) {
        task.add(item);
    }
}

