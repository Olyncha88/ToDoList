package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class ToDoList {
    String topic;
     List <Task> tasks = new ArrayList<>();

    public ToDoList(String topicName) {
        topic = topicName;
    }

    public ToDoList() {
    }

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
        t.setDate(daedLine);
        t.setExecutorName(executName);
        tasks.add(t);
        System.out.println("Task added successfully.");
        }

    public void deleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to delete");
        String taskNameToDel = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while(taskIterator.hasNext()) {//до тех пор, пока в списке есть элементы

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
                tasks.set (tasks.indexOf (nextTask), new Task()); // ???????
                }
            System.out.println("Please enter for correct :\n1.Correct TaskName\n2.Correct date\n3.Correct ExecutorName");
          // далее пролдается метод по изменению задачи
            }


    public void markAsCompletedTask(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to change");
        String taskName = sc.nextLine();
    }
    public void markAsActiveTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to change");
        String taskName = sc.nextLine();
    }
}

// public void reviewingList() {
//    System.out.println("Выбрать пункт: \n1. Добавить задачу \n2. Удалить задачу \n3. Изменить задачу \n4. Пометить как завершенная \n5. Пометить как активная");
