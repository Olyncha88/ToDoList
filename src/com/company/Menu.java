package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// todo Уйди от статики работай с объектом Menu
public class Menu {
    static List<ToDoList> topicTodoList = new ArrayList<>();

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

                    //todo вынести работу с таском в отдельный метод или объект,
                    // чтобы уменьшить вложенность и повысить читаемость
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

    private static void createToDoList() { //создаем ToDoList
        // todo незачем создавать каждый раз сканер, можно вынести его в поле объекта Menu
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        // todo (nit) если не используешь i лучше через for... each писать, так читаемость повышается и нет неиспользуемых
        //  переменных.
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
        // todo см. выше)
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic");
        String topicTD = sc.nextLine();
        // todo см. выше)
        for (int i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                topicTodoList.remove(topicTodoList.get(i));    //удаляем ToDoList с выбранной темой
                System.out.println("ToDoList " + topicTD + " deleted");
                // todo лучше использовать {} даже при 1 строчке, так проще читать и сложнее ошибиться в будущем
                //  И вообще ты выводишь это сообщение на каждой итерации. Это нарушение логики.
            } else System.out.println("Such ToDoList does not exist");
            break;
        }
    }

    private static ToDoList selectToDoList() { //выбираем ToDoList с нужной темой
        // todo см. выше)
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ToDoList topic to select");
        String topicTD = sc.nextLine();
        int i = 0;
        // todo см. выше)
        for (i = 0; i < topicTodoList.size(); i++) {
            if (topicTodoList.get(i).topic.equals(topicTD)) {
                System.out.println("ToDoList topic " + topicTD + " to select");
                return topicTodoList.get(i);
                // todo лучше использовать {} даже при 1 строчке, так проще читать и сложнее ошибиться в будущем
                //  И вообще ты выводишь это сообщение на каждой итерации. Это нарушение логики.
            } else System.out.println("Such ToDoList does not exist");
        }
        // todo Это тут зачем? Если ты не находишь элемент возвращаешь null и обрабатываешь его. В идеале завернуть
        //  объект в Optional и с ним работать-
        return topicTodoList.get(i);

    }
}



