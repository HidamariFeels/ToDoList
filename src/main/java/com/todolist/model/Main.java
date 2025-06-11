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
          try {
          todo.showToDoTasks();
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;
          
        case "done":
          try {
          todo.showCompletedTasks();
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
          break;

        case "check":
          System.out.print("Which task? (ID): ");
          int checkInput = scanner.nextInt();
          scanner.nextLine();
          
          try {
          todo.completeTask(checkInput);
          System.out.println("Task completed!");
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }

        break;
        
        case "save":
          try {
          todo.saveToDo("save.json");
          System.out.println("Saved!");
          } catch (Exception e) {
            System.out.println("Saving file failed.");
          }

          break;

        case "load":
          try {
            todo.loadToDo("save.json");
            System.out.println("Loaded!");
          } catch (Exception e) {
            System.out.println("Saving file failed.");
          }

          break;

        default:
          System.out.println("Unknown command");

      }
    }

    scanner.close();
  }
}
