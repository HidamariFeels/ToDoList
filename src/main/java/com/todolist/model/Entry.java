package com.todolist.model;
public class Entry {
  
  private static int idcounter = 1;

  private String task;
  private String status;
  private int id;

  public Entry(String task, String status) {
    this.task = task;
    this.status = status;
    this.id = idcounter++;
  }

  @Override
  public String toString() {
    return "Task: " + task + "\nStatus: " + status + "\nId: " + id;
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

}
