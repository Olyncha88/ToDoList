package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
     List<ToDoList> topicTodoList = new ArrayList<>();
     private Scanner sc = new Scanner(System.in);

     void run() {

        boolean quit = false;
        String mainMenu = "" + "1. Display Print\n" + "2. Add a toDoList\n" +
                "3. Delete a toDoList\n" + "4. Select a toDoList\n" + "5. Quit\n\n";
        while (!quit) {
            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            System.out.println("Please enter number");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(topicTodoList);
                    break;
                case 2:
                    // + toDo List
                    createToDoList();
                    break;
                case 3:
                    // delete toDo List
                    deleteToDoList();
                    break;
                case 4:
                    // select toDo List
                    selectToDoList().runMenuTask();
                    break;
                case 5:
                    // EXIT
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid entry try again");
            }
        }
        System.exit(0);
    }


    private  void createToDoList() {
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        for (ToDoList i : topicTodoList) {
            if ((i.topic).equals(topicTD)) {
                System.out.println("Topic already exists. Try again");
            }
            continue;
        }
        topicTodoList.add(new ToDoList(topicTD));
        System.out.println("ToDoList Topic " + topicTD + " added successfully");
    }


    private void deleteToDoList() {
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        for (ToDoList i : topicTodoList) {
            if (!(i.topic).equals(topicTD)) {
                //System.out.println("Such ToDoList does not exist"); // для проверки
                continue;
            } else {
                topicTodoList.remove(i);
                System.out.println("ToDoList topic " + topicTD + " deleted");
            } break;
        }
    }

    private ToDoList selectToDoList() {
        System.out.println("Please enter ToDoList topic to select");
        String topicTD = sc.nextLine();
        ToDoList toDoList = null;
        for (ToDoList i : topicTodoList) {
            if (!(i.topic).equals(topicTD)) {
                //System.out.println("ToDoList topic " + topicTD + " to select"); // для проверки
                continue;
            } else {
                toDoList = topicTodoList.get(topicTodoList.indexOf(i));
                System.out.println("ToDoList topic " + topicTD + " to select");
            }
        } return toDoList;
    }

}



