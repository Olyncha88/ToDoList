package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ToDoList {
    String topic;
    List<Task> tasks = new ArrayList<>();

    public ToDoList(String topicName) {
        topic = topicName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ToDoList() {
    }


    public Task createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name");
        String taskName = sc.nextLine();
        System.out.println("Please enter executor name");
        String executName = sc.nextLine();
        System.out.println("Please enter deadline in format dd/MM/yyyy");
        String daedLine = sc.nextLine();
        // Date d = null;
        //try {
        //    d = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
        // } catch (ParseException e) {
        //    e.printStackTrace();
        //}

        Task t = new Task();
        t.setTaskName(taskName);
        t.setExecutorName(executName);
        t.setDate(daedLine);
        tasks.add(t);
        System.out.println("Task added successfully.");
        return t;
    }

    public void deleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to delete");
        String taskNameToDel = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while (taskIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Task nextTask = taskIterator.next();//получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToDel)) {
                taskIterator.remove();//удаляем Task с нужным именем
            }
        }
    }
    public void changeTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to change");
        String taskNameToChange = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while(taskIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Task nextTask = taskIterator.next();//получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToChange)) // ?????????
                tasks.set (tasks.indexOf (nextTask), createTask()); // ???????
        }      // далее пролдается метод по изменению задачи
        System.out.println("Please enter for correct :\n1.Correct TaskName\n2.Correct date\n3.Correct ExecutorName");


        public void getToDoList() { ???????
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void completedByTask(){  ????
        public void markAsCompletedTask(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter task name as completed");
            String taskName = sc.nextLine();

        }
        public void markAsActiveTask() { ??????
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter task name to change");
            String taskName = sc.nextLine();
        }
    }
    }
}


