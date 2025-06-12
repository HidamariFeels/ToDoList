package com.todolist.model;

import com.todolist.exception.EmptyListException;
import com.todolist.exception.TaskNotFoundException;
import com.todolist.model.Entry.Priority;

public class ToDoListTest {

  public static void main(String[] args) throws TaskNotFoundException, EmptyListException {

    // Test 1 - Adding an entry to the to-do list
    ToDoList todo = new ToDoList();

    todo.addTask("complete this project", Priority.HIGH);
    
    System.out.println("Test 1 - Add entry to to-do\n" + todo.getTodo().get(0));

    // Test 2 - Completing a task
    
    todo.completeTask(1);

    System.out.println("\nTest 2 - Complete task\n" + todo.getCompleted().get(0));

    // Test 3 - Showing list of to-do tasks
    
    System.out.println("\nTest 3 - Show to-do tasks");
    
    todo.addTask("go on a walk", Priority.LOW);
    todo.addTask("cook dinner", Priority.MEDIUM);
    todo.addTask("do homework", Priority.HIGH);


    todo.showToDoTasks();

    // Test 4 -Showing list of completed tasks

    System.out.println("Test 4 - Show completed tasks\n");

    todo.completeTask(2);
    todo.completeTask(3);

    todo.showCompletedTasks();
  }

}
