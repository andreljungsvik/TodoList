package se.yrgo.main;

import se.yrgo.model.Task;
import se.yrgo.model.TodoList;
import se.yrgo.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                System.out.println("Enter email: ");
                String email = sc.nextLine();
                User usr = new User(id, name, email);
                TodoList tdl = new TodoList();
                int in;
                do {
                    System.out.printf("1. Create new task%n2. Remove task%n3. View tasks%n" +
                            "4. Set task status%n5. Save lists%n6. Show user%n0. Exit%n");
                    in = sc.nextInt();
                    sc.nextLine();
                    switch (in) {
                        case 1:
                            String taskName;
                            String desc;
                            System.out.print("Name the task: ");
                                taskName = sc.nextLine();
                            System.out.print("Task description: ");
                                desc = sc.nextLine();
                            tdl.addTask(new Task(taskName, desc));
                            break;
                        case 2:
                            if (tdl.filterTasks(false).isEmpty()) {
                                System.out.println("No tasks found\n");
                            } else {
                                System.out.println("Which task will you remove?");
                                for (int i = 0; i < tdl.filterTasks(false).size(); i++) {
                                    System.out.println(i+1 + ". " + tdl.filterTasks(false).get(i).toString());
                                }
                                System.out.println("0. Cancel");
                                if (sc.nextInt() == 0) {
                                    break;
                                }
                                tdl.removeTask(tdl.filterTasks(false).get(sc.nextInt()-1));
                                sc.nextLine();
                            }
                            break;
                        case 3:
                            System.out.printf("1. Show completed tasks%n2. Show incomplete tasks%n0. Cancel%n");
                            in = sc.nextInt();
                            if (in == 1) {
                                if (tdl.filterTasks(true).isEmpty()) {
                                    System.out.println("No tasks found\n");
                                } else {
                                    for (Task task : tdl.filterTasks(true)) {
                                        System.out.println(task.toString());
                                    }
                                }
                            }
                            else if (in == 2) {
                                if (tdl.filterTasks(false).isEmpty()) {
                                    System.out.println("No tasks found\n");
                                } else {
                                    for (Task task : tdl.filterTasks(false)) {
                                        System.out.println(task.toString());
                                    }
                                }
                            }
                            break;
                        case 4:
                            System.out.printf("1. Completed tasks%n2. Incomplete tasks%n0. Cancel%n");
                            in = sc.nextInt();
                            if (in == 0) {
                                break;
                            } else if (in == 1) {
                                if (tdl.filterTasks(true).isEmpty()) {
                                    System.out.println("No tasks found\n");
                                } else {
                                    System.out.println("Which task will you set as incomplete?");
                                    for (int i = 0; i < tdl.filterTasks(true).size(); i++) {
                                        System.out.println(i+1 + ". " + tdl.filterTasks(true).get(i).toString());
                                    }
                                    in = sc.nextInt();
                                    tdl.filterTasks(true).get(in-1).setCompleted(false);

                                }
                            } else if (in == 2) {
                                if (tdl.filterTasks(false).isEmpty()) {
                                    System.out.println("No tasks found\n");
                                } else {
                                    System.out.println("Which task will you set as complete?");
                                    for (int i = 0; i < tdl.filterTasks(false).size(); i++) {
                                        System.out.println(i+1 + ". " + tdl.filterTasks(false).get(i).toString());
                                    }
                                    in = sc.nextInt();
                                    tdl.filterTasks(false).get(in -1).setCompleted(true);
                                }
                            }
                            sc.nextLine();
                            break;
                        case 5:
                            System.out.printf("1. Save list%n0. Cancel%n");
                            in = sc.nextInt();
                            if (in == 0) {
                                break;
                            } else if (in == 1) {
                                usr.addTodoList(tdl);
                                tdl = new TodoList();
                                System.out.printf("Saved list to user%n");
                            }
                            break;
                        case 6:
                            System.out.println(usr.toString());
                            break;
                        case 0:
                            System.out.println("Goodbye!");
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid input");
                    }
                } while (in != 0);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }

    }
}