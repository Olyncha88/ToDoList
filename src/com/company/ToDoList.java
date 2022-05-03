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
    // todo В идеале нужно логику создания объекта создать в отдельном класс TaskDAO или TaskRepository
    //  а объект добавлять в список через setter. Мы это не проходили еще, но если сможешь сделай так, нет,
    //  оставь как есть. Пока это не ошибка) Просто хочу попробовать дать тебе возможность
    //  продвинуться чуть-чуть дальше самостоятельно.)
    public void createTask() {
        // todo незачем создавать каждый раз сканер, можно вынести его в поле объекта Menu
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
        // todo незачем создавать каждый раз сканер, можно вынести его в поле объекта Menu
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to delete");
        String taskNameToDel = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while (taskIterator.hasNext()) {
                Task nextTask = taskIterator.next();    //получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToDel)) {
                taskIterator.remove();//удаляем Task с нужным именем
                System.out.println("Task " + taskNameToDel + " deleted");
                // todo лучше использовать {} даже при 1 строчке, так проще читать и сложнее ошибиться в будущем
                //  И вообще ты выводишь это сообщение на каждой итерации. Это нарушение логики.
            } else System.out.println("Such Task does not exist");
            // todo Зачем здесь break? Здесь он бесполезен. Его можно воткнуть на 69 строчку.
            break;
        }
    }

    public void changeTask() {
        // todo незачем создавать каждый раз сканер, можно вынести его в поле объекта Menu
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter task name to change. Next enter new: \\n1.Correct TaskName\\n2.Correct date\\n3.Correct ExecutorName");
        String taskNameToChange = sc.nextLine();
        Iterator<Task> taskIterator = tasks.iterator();//создаем итератор
        while (taskIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Task nextTask = taskIterator.next();//получаем следующий элемент
            if (nextTask.getTaskName().equals(taskNameToChange)) {
                tasks.set(tasks.indexOf(nextTask), new Task(sc.nextLine(), sc.nextLine(), sc.nextLine(), false)); // ???????
                System.out.println("Task changed successfully");
                // todo нужно добавить break не буду писать во всех местах, посмотри сама, пожалуйста.
                // todo лучше использовать {} даже при 1 строчке, так проще читать и сложнее ошибиться в будущем
                //  И вообще ты выводишь это сообщение на каждой итерации. Это нарушение логики.
            } else System.out.println("Such Task does not exist");
        }
    }

    // todo Замечания те же, что и раньше надоело повторяться. Верю, что ты справишься сама)
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

