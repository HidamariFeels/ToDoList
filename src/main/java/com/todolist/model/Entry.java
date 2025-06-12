package com.todolist.model;
public class Entry {
  
  private static int idcounter = 1;

  private String task;
  private String status;
  private int id;

  enum Priority {
    HIGH, MEDIUM, LOW
  }

  private Priority priority;


  public Entry(String task, String status, Priority priority) {
    this.task = task;
    this.status = status;
    this.priority = priority;
    this.id = idcounter++;
  }

  @Override
  public String toString() {
    return "Task: " + task + "\nStatus: " + status + "\nPriority: " + priority + "\nId: " + id;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

}
