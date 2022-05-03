package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;


public class ToDoList {
    String topic;
    List<Task> tasks = new ArrayList<>();

    public ToDoList(String topicName) {
        topic = topicName;
    }

    public ToDoList() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    // private Scanner sc = new Scanner(System.in);

    public void createTask() {
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
        t.setDone(false);
        tasks.add(t);
        System.out.println("Task " + taskName + " added successfully.");
    }

    public void deleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to delete");
        String taskNameToDel = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while (taskIterator.hasNext()) {
                Task nextTask = taskIterator.next();    //получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToDel)) {
                taskIterator.remove();//удаляем Task с нужным именем
                System.out.println("Task " + taskNameToDel + " deleted");
            } else System.out.println("Such Task does not exist");
            break;
        }
    }

    public void changeTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to change. Next enter new: \\n1.Correct TaskName\\n2.Correct date\\n3.Correct ExecutorName");
        String taskNameToChange = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while (taskIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Task nextTask = taskIterator.next();//получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToChange)) {
                tasks.set(tasks.indexOf(nextTask), new Task(sc.nextLine(), sc.nextLine(), sc.nextLine(), false)); // ???????
                System.out.println("Task changed successfully");
            } else System.out.println("Such Task does not exist");
        }
    }

    public void markCompletedTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to mark it as completed");
        String taskNameToCompleted = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while (taskIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Task nextTask = taskIterator.next();//получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToCompleted)) {
                tasks.set(tasks.indexOf(nextTask), new Task(nextTask.getTaskName(), nextTask.getDate(),nextTask.getExecutorName(),true));
            System.out.println("Task " + taskNameToCompleted + " is marked as completed");
                System.out.println(tasks.toString());
        } else System.out.println("Such Task does not exist");
        }
    }

    @Override
    public String toString() {
        return "ToDoList: " + topic + " ";
    }
}

