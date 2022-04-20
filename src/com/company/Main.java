package com.company;

public class Main {

    public static void main(String[] args) {

//The run function will start the menu on the output screen
       // Menu.run();
        ToDoList toDay = new ToDoList("bank");
        toDay.createTask();// проверка добаления задачи в лист
        System.out.println(toDay.topic + toDay.tasks);
        //toDay.deleteTask();
        //System.out.println(toDay.topic + toDay.tasks); // проверка удаления задачи в листе
        toDay.changeTask();
        System.out.println(toDay.topic + toDay.tasks);

    }

}
