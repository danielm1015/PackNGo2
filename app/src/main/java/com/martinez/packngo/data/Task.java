package com.martinez.packngo.data;

/**
 * Created by Daniel Martinez on 7/22/2017.
 */

public class Task {

    private int taskId;
    private String taskName, notes;


    public Task() {

    }

    public Task( String taskName, String notes) {
        this.taskName = taskName;
        this.notes = notes;

    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


}