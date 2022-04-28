package com.company;


public class Task {
    private String taskName;
    private String date;
    private String executorName;
    private boolean isDone;

    Task(String taskName, String date, String executorName, boolean isDone) { // конструктор
        this.taskName = taskName;
        this.date = date;
        this.executorName = executorName;
        this.isDone = isDone;
    }

    public Task() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;}

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Task name = " + taskName + " , executor = " + executorName +
                " , deadline = " + date + ", Done = " + isDone;
    }

}
