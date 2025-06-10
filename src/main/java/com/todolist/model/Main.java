package com.todolist.model;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    ToDoList todo = new ToDoList();

    if (args.length == 1) {
      
      String arg = args[0];

      switch (arg) {
        
        case "add":
          System.out.println("Enter task:");
          String taskInput = scanner.nextLine();

          todo.addTask(taskInput);

          System.out.println("Task added!");

          todo.showToDoTasks();

      }
    }
  }

}
