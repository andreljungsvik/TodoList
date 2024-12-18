package se.yrgo.model;

import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        while(true) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.printf("1. Create new task%n2. Remove task%n3. View tasks");
                String in = sc.nextLine();
                TodoList tdl = new TodoList();
                switch (in) {
                    case "1":
                        System.out.print("Name the task: ");
                        String name = sc.nextLine();
                        System.out.print("Task description: ");
                        String desc = sc.nextLine();
                        tdl.addTask(new Task(name, desc));
                        break;
                    case "2":
                        System.out.println("Which task will you remove?");
                        //display tasks
                        tdl.removeTask(null);
                        break;
                    case "3":
                        System.out.printf("1. Show completed tasks%n2. Show incomplete tasks");
                        in = sc.nextLine();
                        if (in.equals("1")) {
                            for (Task task : tdl.filterTasks(true)) {
                                System.out.println(task);
                            }
                        }
                        else if (in.equals("2")) {
                            for (Task task : tdl.filterTasks(false)) {
                                System.out.println(task);
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input");
                }
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}