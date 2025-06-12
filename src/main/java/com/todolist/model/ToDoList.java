package com.todolist.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import com.todolist.exception.EmptyListException;
import com.todolist.exception.TaskNotFoundException;
import com.todolist.model.Entry.Priority;

public class ToDoList {
  
  private ArrayList<Entry> todo;
  private ArrayList<Entry> completed;

  public ToDoList() {
    todo = new ArrayList<Entry>();
    completed = new ArrayList<Entry>();
  }

  public void addTask(String task, Priority priority) {
    Entry entry = new Entry(task, "to-do", priority);
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

  public void showToDoTasks() throws EmptyListException {
    if (todo.isEmpty()) {
      throw new EmptyListException("List is empty, good job!");
    }
    for (Entry e : todo) {
      System.out.println(e + "\n");
    }
  }

  public void showCompletedTasks() throws EmptyListException {
    if (completed.isEmpty()) {
      throw new EmptyListException("List is empty, better start working...");
    }
    for (Entry e : completed) {
      System.out.println(e + "\n");
    }
  }

  public void saveToDo(String file) throws IOException {
    Gson gson = new Gson();
    try (FileWriter writer = new FileWriter(file)) {
      gson.toJson(this, writer);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void loadToDo(String file) throws IOException
  {
    Gson gson = new Gson();
    try (FileReader reader = new FileReader(file)) {
      ToDoList loadedToDo = gson.fromJson(reader, ToDoList.class);
      this.todo = loadedToDo.todo;
      this.completed = loadedToDo.completed;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void sortByPriority() throws EmptyListException {
    Comparator<Entry> compareByPriority = Comparator.comparing(Entry::getPriority);
    
    ArrayList<Entry> sortedTasks = (ArrayList<Entry>) todo.stream().sorted(compareByPriority)
        .collect(Collectors.toList());

    ArrayList<Entry> unsortedTasks = todo;
    todo = sortedTasks;
    showToDoTasks();
    todo = unsortedTasks;
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
