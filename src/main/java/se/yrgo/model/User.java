package se.yrgo.model;

import se.yrgo.model.*;

public class User {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Current tasks");
                //display tasks

                System.out.printf("1. Create new task%n2. Remove task%n3. Filter tasks");
                String in = sc.nextLine;
                TodoList tdl = new TodoList();
                switch (in) {
                    case "1":
                        System.out.print("Name the task: ");
                        String name = sc.nextLine;
                        System.out.print("Task description: ");
                        String desc = sc.nextLine;
                        tdl.addTask(new Task(name, desc));
                        break;
                    case "2":
                        System.out.println("Which task will you remove?");
                        //display tasks
                        tdl.removeTask(null);
                        break;
                    case "3":
                        System.out.printf("1. Show completed tasks%n2. Show incomplete tasks");
                        in = sc.nextInt;
                        if (in == 1) {
                            tdl.filterTasks(true);
                        }
                        else if (in == 2) {
                            tdl.filterTasks(false);
                        }
                        break;
                    default:
        
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}