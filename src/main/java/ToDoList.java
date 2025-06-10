import java.util.ArrayList;

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
