public class Entry {

  private String task;
  private String status;

  public Entry(String task, String status) {
    this.task = task;
    this.status = status;
  }

  @Override
  public String toString() {
    return "Task: " + task + "\nStatus: " + status;
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

}
