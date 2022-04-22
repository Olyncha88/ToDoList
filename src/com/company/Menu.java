package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    static List<ToDoList> topicTodoList = new ArrayList<>();

    private static void createToDoList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                System.out.println("Topic already exists. Try again");
                return;
            }
        }
        topicTodoList.add(new ToDoList(topicTD));
        System.out.println("Topic ToDoList added successfully");
    }

    private static void deleteToDoList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                topicTodoList.remove(topicTodoList.get(i));    //удаляем ToDoList с выбранной темой
                System.out.println("ToDoList deleted");
            }
        }
    }

        private static void run() {

            boolean quit = false;
            String mainMenu = "" + "1. Display Print\n" + "2. Add a toDoList\n" +
                    "3. Delete a toDoList\n" + "4. Select a toDoList\n" + "5. Quit\n\n";
            while (!quit) {

                //The Scanner will input the user's choice
                Scanner input = new Scanner(System.in);
                System.out.println(mainMenu);
                int choice = input.nextInt();

                switch (choice) {
                    case 1:

                        break;
                    case 2:
                        // + toDo List

                        break;
                    case 3:
                        // delete toDo List
                        deleteToDoList();
                        break;
                    case 4:
                        // select toDo List
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
}

