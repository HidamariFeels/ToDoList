public class ToDoListTest {

  public static void main(String[] args) {

    // Test 1 - Adding an entry to the to-do list
    ToDoList todo = new ToDoList();

    todo.addEntry("complete this project");
    
    System.out.println("Test 1 - Add entry to to-do\n" + todo.getTodo().get(0));

    // Test 2 - Completing a task
    
    todo.completeTask(1);
    
    System.out.println("\nTest 2 - Complete task\n" + todo.getCompleted().get(0));

  }

}
