package com.todolist.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import com.todolist.model.Entry.Priority;

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
          String taskInput = scanner.nextLine();

          try {
          System.out.print("Enter priority (low/medium/high): ");
          String priorityInput = scanner.nextLine();
          Priority priority = Priority.valueOf(priorityInput.toUpperCase());

          todo.addTask(taskInput, priority);

          System.out.println("Task added!");
        } catch (Exception e) {
          System.out.println("Invalid priority");
        }
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

          int checkInput;

          while (true) {
            System.out.print("Which task? (ID): ");
            if (scanner.hasNextInt()) {
              checkInput = scanner.nextInt();
              scanner.nextLine();
              break;
            } else {
              System.out.println("Please enter an integer");
              scanner.nextLine();
            }
          }
          
          try {
          todo.completeTask(checkInput);
          System.out.println("Task completed!");
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
          
          break;

        case "sort":
          try { 
            todo.sortByPriority();
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
            System.out.println("Loading file failed.");
          }

          break;

        case "help":

          try (BufferedReader reader = new BufferedReader(new FileReader("README.md"))) {

            String line;
            while ((line = reader.readLine()) != null) {
              System.out.println(line);
            }
          } catch (Exception e) {
            System.out.println("README.md file not found");
          }

          break;

        default:
          System.out.println("Unknown command");

      }
    }

    scanner.close();
  }
}
