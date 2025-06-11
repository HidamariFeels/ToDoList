package com.todolist.exception;

import com.todolist.model.ToDoList;

public class EmptyListExceptionTest {

  public static void main(String[] args) {

    System.out.println("Test 1 - Empty To-Do list\n");

    ToDoList todo = new ToDoList();

    try {
      todo.showToDoTasks();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
    System.out.println("\nTest 2 - Empty Completed list\n");

    try {
      todo.showCompletedTasks();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
