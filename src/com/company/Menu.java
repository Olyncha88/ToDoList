package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Menu {
    List<ToDoList> topicTodoList = new ArrayList<>();

    public void createToDoList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        ToDoList tD = new ToDoList();
        tD.setTopic(topicTD);
        topicTodoList.add(tD);
    }
    public void deleteToDoList(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        Iterator<ToDoList> toDoListIterator = topicTodoList.iterator(); //создаем итератор
        while (toDoListIterator.hasNext()) {                           //до тех пор, пока в списке есть элементы
            ToDoList nextToDoList = toDoListIterator.next();            //получаем следующий элемент
            if (nextToDoList.equals(topicTD)) {
                toDoListIterator.remove();                              //удаляем ToDoList с нужным именем
            }
    }
        public void getTopicToDoList(){
            for (ToDoList toDoList : topicTodoList) {
                System.out.println(toDoList);
            }
        }

    static void run() {

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
                    getTopicToDoList;
                    break;
                case 2:
                    // + toDo List
                    ToDoList newToDoList = new ToDoList();

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

        private static void addTopic () {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter topic name");
            String name = sc.nextLine();

            for (int i = 0; i < topicTodoList.size(); i++) {
                if (topicTodoList.get(i).topic.equals(name)) {
                    System.out.println("Topic already exists. Try again");
                    return;
                }
            }
            topicTodoList.add(new ToDoList(name));
            System.out.println("Topic added successfully");
        }
}
