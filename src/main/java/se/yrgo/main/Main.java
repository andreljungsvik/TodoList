package se.yrgo.main;

import se.yrgo.model.Task;
import se.yrgo.model.TodoList;
import se.yrgo.model.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            User usr = createUser(sc);
            TodoList tdl = new TodoList();
            int in;
            do {
                System.out.printf("1. Create new task%n2. Remove task%n3. View tasks%n" +
                        "4. Set task status%n5. Save lists%n6. Show user%n0. Exit%n");
                in = sc.nextInt();
                sc.nextLine();
                if (in > 6 || in < 0) {
                    throw new IllegalArgumentException("invalid input");
                }
                switch (in) {
                    case 1:
                        System.out.print("Name the task: ");
                        String taskName = sc.nextLine();
                        System.out.print("Task description: ");
                        String desc = sc.nextLine();
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
                            in = sc.nextInt();
                            if (in > tdl.filterTasks(false).size() || in < 0) {
                                throw new IllegalArgumentException("invalid input");
                            }
                            if (in == 0) {
                                break;
                            }
                            tdl.removeTask(tdl.filterTasks(false).get(in-1));
                        }
                        break;
                    case 3:
                        System.out.printf("1. Show current todo list%n2. Show saved todo lists%n0. Cancel%n");
                        in = sc.nextInt();
                        if (in > 2 || in < 0) {
                            throw new IllegalArgumentException("invalid input");
                        }
                        if (in == 0) {
                            break;
                        } else if (in == 1) {
                            showCurrentTasks(tdl, sc);
                        } else if (in == 2) {
                            for (int i = 1; i <= usr.getTodoLists().size(); i++) {
                                System.out.println("Todo list " + i);
                                for (int j = 0; j < usr.getTodoLists().get(i-1).getTasks().size(); j++) {
                                    System.out.println(usr.getTodoLists().get(i-1).getTasks().get(j).toString());
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.printf("1. Completed tasks%n2. Incomplete tasks%n0. Cancel%n");
                        in = sc.nextInt();
                        if (in > 2 || in < 0) {
                            throw new IllegalArgumentException("invalid input");
                        }
                        if (in == 0) {
                            break;
                        } else if (in == 1) {
                            setToIncomplete(tdl, sc);
                        } else if (in == 2) {
                            setToCompleted(tdl, sc);
                        }
                        sc.nextLine();
                        break;
                    case 5:
                        usr.addTodoList(tdl);
                        tdl = new TodoList();
                        System.out.printf("Saved list to user%n");
                        break;
                    case 6:
                        System.out.println(usr);
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

    /**
     * Shows the current todo list and lets the user choose to view completed or incomplete tasks
     * prints "No tasks found" if list of tasks is empty
     * @param tdl a list of tasks
     * @param sc
     */
    private static void showCurrentTasks(TodoList tdl, Scanner sc) {
        System.out.printf("1. Show completed tasks%n2. Show incomplete tasks%n");
        int in = sc.nextInt();
        if (in > 2 || in < 1) {
            throw new IllegalArgumentException("invalid input");
        }
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
    }

    /**
     * Asks the user for ID, name and email from the terminal,
     * using these as argument for creating an instance of User
     *
     * @param sc
     * @return a User object
     */
    private static User createUser(Scanner sc) {
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        return new User(id, name, email);
    }

    /**
     * Sets a completed task of choice to incomplete,
     * prints "No tasks found" if the list of tasks is empty
     * @param tdl list of completed tasks
     * @param sc
     */
    private static void setToIncomplete(TodoList tdl, Scanner sc) {
        if (tdl.filterTasks(true).isEmpty()) {
            System.out.println("No tasks found\n");
        } else {
            System.out.println("Which task will you set as incomplete?");
            for (int i = 0; i < tdl.filterTasks(true).size(); i++) {
                System.out.println(i+1 + ". " + tdl.filterTasks(true).get(i).toString());
            }
            int in = sc.nextInt();
            if (in > tdl.filterTasks(true).size() || in < 1) {
                throw new IllegalArgumentException("invalid input");
            }
            tdl.filterTasks(true).get(in-1).setCompleted(false);
        }
    }

    /**
     * Sets an incomplete task of choice to completed,
     * prints "No tasks found" if list of tasks is empty
     * @param tdl list of incomplete tasks
     * @param sc
     */
    private static void setToCompleted(TodoList tdl, Scanner sc) {
        if (tdl.filterTasks(false).isEmpty()) {
            System.out.println("No tasks found\n");
        } else {
            System.out.println("Which task will you set as complete?");
            for (int i = 0; i < tdl.filterTasks(false).size(); i++) {
                System.out.println(i+1 + ". " + tdl.filterTasks(false).get(i).toString());
            }
            int in = sc.nextInt();
            if (in > tdl.filterTasks(false).size() || in < 1) {
                throw new IllegalArgumentException("invalid input");
            }
            tdl.filterTasks(false).get(in -1).setCompleted(true);
        }
    }
}