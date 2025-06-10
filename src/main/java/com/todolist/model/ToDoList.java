package com.todolist.model;
import java.util.ArrayList;
import java.util.Iterator;
import com.todolist.exception.TaskNotFoundException;

public class ToDoList {
  
  private ArrayList<Entry> todo;
  private ArrayList<Entry> completed;

  public ToDoList() {
    todo = new ArrayList<Entry>();
    completed = new ArrayList<Entry>();
  }

  public void addEntry(String task) {
    Entry entry = new Entry(task, "to-do");
    todo.add(entry);
  }

  public void completeTask(int id) throws TaskNotFoundException {
    Entry task = getEntryById(id);

    task.setStatus("completed");
    todo.remove(task);
    completed.add(task);
  }

  public Entry getEntryById(int id) throws TaskNotFoundException {
    Iterator<Entry> it = todo.iterator();
    
    // Iterate through to-do list
    while (it.hasNext()) {
      Entry task = it.next();
      // If the ID matches
      if (task.getId() == id) {
        // Return the task
        return task;
      }
    }

    throw new TaskNotFoundException("Task with ID " + id + " not found");
  }

  public ArrayList<Entry> getTodo() {
    return todo;
  }

  public void setTodo(ArrayList<Entry> todo) {
    this.todo = todo;
  }

  public ArrayList<Entry> getCompleted() {
    return completed;
  }

  public void setCompleted(ArrayList<Entry> completed) {
    this.completed = completed;
  }
  
}
