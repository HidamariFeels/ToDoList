import java.util.ArrayList;
import java.util.Iterator;

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

  public void completeTask(int id) {
    Entry task = getEntryById(id);

    task.setStatus("completed");
    todo.remove(task);
    completed.add(task);
  }

  public Entry getEntryById(int id) {
    Iterator<Entry> it = todo.iterator();
    Entry taskToBeReturned = null;
    
    // Iterate through to-do list
    while (it.hasNext()) {
      Entry task = it.next();
      // If the ID matches
      if (task.getId() == id) {
        // Set the task to be returned
        taskToBeReturned = task;
        break;
      }
    }

    // Return the task
    return taskToBeReturned;
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
