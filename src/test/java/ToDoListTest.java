public class ToDoListTest {

  public static void main(String[] args) {

    // Test 1 - Adding an entry to the to-do list
    ToDoList todo = new ToDoList();

    todo.addEntry("complete this project");
    
    System.out.println(todo.getTodo().get(0));
  }

}
