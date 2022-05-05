package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Scanner;


public class ToDoList {
    String topic;
    List<Task> tasks = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

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

    public void createTask() {
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
        System.out.println("Task " + taskName + " added successfully");
    }

    public void deleteTask() {
        System.out.println("Please enter task name to delete");
        String taskNameToDel = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()) {
                Task nextTask = taskIterator.next();
            if (!nextTask.getTaskName().equals(taskNameToDel)) {
                continue;
            } else {
                taskIterator.remove();
                System.out.println("Task " + taskNameToDel + " deleted");
            } break;
        }
    }

    public void changeTask() {
        System.out.println("Please enter task name to change. Next enter new: \\n1.Correct TaskName\\n2.Correct date\\n3.Correct ExecutorName");
        String taskNameToChange = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()) {
            Task nextTask = taskIterator.next();
            if (!nextTask.getTaskName().equals(taskNameToChange)) {
                continue;
            }
            else {
                tasks.set(tasks.indexOf(nextTask), new Task(sc.nextLine(), sc.nextLine(), sc.nextLine(), false));
                System.out.println("Task changed successfully");
            }
            //System.out.println(tasks); // для проверки правильности работы метода
        break;
        }
    }

    public void markCompletedTask() {
        System.out.println("Please enter task name to mark it as completed");
        String taskNameToCompleted = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();
        while (taskIterator.hasNext()) {
            Task nextTask = taskIterator.next();
            if (!nextTask.getTaskName().equals(taskNameToCompleted)) {
                continue;
            } else tasks.set(tasks.indexOf(nextTask), new Task(nextTask.getTaskName(), nextTask.getDate(),nextTask.getExecutorName(),true));
            System.out.println("Task " + taskNameToCompleted + " is marked as completed");
                //System.out.println(tasks.toString()); // для проверки правильности работы метода
        break;
        }
    }

    public void runMenuTask(){
        boolean quitMenu = false;

        String menuTask = ("" + "1. Add a Task\n" +
                "2. Delete a Task\n" + "3. Change a Task\n" + "4. Mark a Task as completed\n" +
                "5. Quit Menu\n\n");

        while (!quitMenu) {
            Scanner inputTask = new Scanner(System.in);
            System.out.println(menuTask);
            System.out.println("Please enter number for Task");
            int choiceTask = inputTask.nextInt();
            switch (choiceTask) {
                case 1:
                    createTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    changeTask();
                    break;
                case 4:
                    markCompletedTask();
                    break;
                case 5:
                    // EXIT in Menu
                    quitMenu = true;
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "ToDoList: " + topic + " ";
    }
}

