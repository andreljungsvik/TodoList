package se.yrgo.main;

import se.yrgo.model.Task;
import se.yrgo.model.TodoList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            try (Scanner sc = new Scanner(System.in)) {
                TodoList tdl = new TodoList();
                int in;
                do {
                    System.out.printf("1. Create new task%n2. Remove task%n3. View tasks%n0. Exit%n");
                    in = sc.nextInt();
                    sc.nextLine();
                    switch (in) {
                        case 1:
                            String name;
                            String desc;
                            System.out.print("Name the task: ");
                                name = sc.nextLine();
                            System.out.print("Task description: ");
                            if (sc.nextInt() == 0) {
                                break;
                            } else {
                                desc = sc.nextLine();
                            }
                            tdl.addTask(new Task(name, desc));
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
                                //doesn't work
                                if (tdl.filterTasks(true).isEmpty()) {
                                    System.out.println("No tasks found\n");
                                } else {
                                    for (Task task : tdl.filterTasks(true)) {
                                        System.out.println(task.toString());
                                    }
                                }
                            }
                            else if (in == 2) {
                                //doesn't work
                                if (tdl.filterTasks(false).isEmpty()) {
                                    System.out.println("No tasks found\n");
                                } else {
                                    for (Task task : tdl.filterTasks(false)) {
                                        System.out.println(task.toString());
                                    }
                                }
                            }
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