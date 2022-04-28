package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    static List<ToDoList> topicTodoList = new ArrayList<>();

    private static void createToDoList() { //создаем ToDoList
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                System.out.println("Topic already exists. Try again");
            }
            return;
        }
        topicTodoList.add(new ToDoList(topicTD));
        System.out.println("Topic added successfully");
    }


    private static void deleteToDoList() { //удаляем ToDoList с нужной темой
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                topicTodoList.remove(topicTodoList.get(i));    //удаляем ToDoList с выбранной темой
                System.out.println("ToDoList " + topicTD + " deleted");
            } else System.out.println("Such ToDoList does not exist");
            break;
        }
    }

    private static ToDoList selectToDoList() { //выбираем ToDoList с нужной темой
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic to select");
        String topicTD = sc.nextLine();
        int i = 0;
        for (i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                System.out.println("ToDoList topic " + topicTD + " to select");
                return topicTodoList.get(i);
            } else System.out.println("Such ToDoList does not exist");
        }
        return topicTodoList.get(i);

    }

    static void run() {

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
                    selectToDoList();

                    boolean quitMenu = false;

                    String menuTask = ("" + "1. Add a Task\n" +
                            "2. Delete a Task\n" + "3. Change a Task\n" + "4. Mark a Task as completed\n" +
                            "5. Quit Menu\n\n");

                    System.out.println(menuTask);

                    while (!quitMenu) {
                        Scanner inputTask = new Scanner(System.in);
                        System.out.println("Please enter number for Task");
                        System.out.println(menuTask);
                        int choiceTask = inputTask.nextInt();
                        switch (choiceTask) {
                            case 1:
                                // + Task
                                selectToDoList().createTask();
                                break;
                            case 2:
                                // del Task
                                selectToDoList().deleteTask();
                                break;
                            case 3:
                                // change Task
                                selectToDoList().changeTask();
                                break;
                            case 4:
                                // mark completed Task
                                selectToDoList().markCompletedTask();
                                break;
                            case 5:
                                // EXIT Menu
                                quitMenu = true;
                                break;
                        }
                    }

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



