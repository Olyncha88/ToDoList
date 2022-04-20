package com.company;

import java.util.Scanner;

public class Menu {

    //provide your ToDoList object
    //declare your ToDoList topic

    static void run() {

        boolean quit = false;
        String mainMenu = "" + "1. Display Print\n" + "2. Add a toDoList\n" + "3. Delete a toDoList\n" + "4. Select a toDoList\n" + "5. Quit\n\n";
        while (!quit) {

            //The Scanner will input the user's choice
            Scanner input = new Scanner(System.in);
            System.out.println(mainMenu);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("ToDoList");
                    break;
                case 2:
                // + toDo List
                    break;
                case 3:
                // delete toDo List
                    break;
                case 4:
                // select toDo List
                    break;
                case 5:
                // EXIT
                    break;
                default:
                    System.out.println("Invalid entry try again");
            }
        }
        System.exit(0);
    }
}
