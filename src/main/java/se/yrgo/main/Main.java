package se.yrgo.main;

import se.yrgo.model.Task;
import se.yrgo.model.TodoList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.printf("1. Create new task%n2. Remove task%n3. View tasks%n");
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
                        if (tdl.filterTasks(false).isEmpty()) {
                            System.out.println("No tasks found\n");
                        } else {
                            System.out.printf("Which task will you remove?");
                            for (int i = 0; i < tdl.filterTasks(false).size(); i++) {
                                System.out.println(i + ". " + tdl.filterTasks(false).get(i));
                            }
                            tdl.removeTask(tdl.filterTasks(false).get(sc.nextInt()));
                        }
                        break;
                    case "3":
                        System.out.printf("1. Show completed tasks%n2. Show incomplete tasks\n");
                        in = sc.nextLine();
                        if (in.equals("1")) {
                            if (tdl.filterTasks(true).isEmpty()) {
                                System.out.println("No tasks found\n");
                            } else {
                                for (Task task : tdl.filterTasks(true)) {
                                    System.out.println(task);
                                }
                            }
                        }
                        else if (in.equals("2")) {
                            if (tdl.filterTasks(false).isEmpty()) {
                                System.out.println("No tasks found\n");
                            } else {
                                for (Task task : tdl.filterTasks(false)) {
                                    System.out.println(task);
                                }
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