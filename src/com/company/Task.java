package com.company;


public class Task {
    private String taskName;
    private String date;
    private String executorName;
    private boolean isDone;

    //todo public
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
    public void setDate(String date) {this.date = date;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }



    @Override
    public String toString() {
        return "Task name = " + taskName + " , executor = " + executorName + " , deadline = " + date + ", Done = " + isDone;
    }

    // todo лучше getter-ы и setter-ы, затем toString. Не очень важное замечание
    //  (not important thing или nit). Но четкая структура класса выгоднее смотрится.
    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
