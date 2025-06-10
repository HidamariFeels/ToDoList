package com.todolist.model;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ToDoList todo = new ToDoList();

    while (true) {
      System.out.print("Enter command: ");
      String cmd = scanner.nextLine();
      
      if (cmd.equals("exit")) {
        System.out.println("Exiting...");
        break;
      }

      switch (cmd) {
        
        case "add":
          System.out.print("Enter task: ");
          String addInput = scanner.nextLine();

          todo.addTask(addInput);

          System.out.println("Task added!");
          break;

        case "todo":
          todo.showToDoTasks();
          break;
          
        case "done":
          todo.showCompletedTasks();
          break;

        case "check":
          System.out.println("Which task? (ID): ");
          int checkInput = scanner.nextInt();
          scanner.nextLine();
          
          try {
          todo.completeTask(checkInput);
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }

        break;

        default:
          System.out.println("Unknown command");

      }
    }
  }
}
