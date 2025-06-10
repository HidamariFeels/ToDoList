package com.todolist.exception;

import com.todolist.model.ToDoList;

public class TaskNotFoundExceptionTest {

  public static void main(String[] args) {

    ToDoList todo = new ToDoList();

    System.out.println("Test 1 - Trying to return ID of non-existent task \n");
    
    try {
    todo.completeTask(1);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
