package com.todolist.exception;

public class EmptyListException extends Exception {

  private static final long serialVersionUID = 1L;

  public EmptyListException(String message) {
    super(message);
  }

}
