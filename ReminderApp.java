import java.util.*;

public class ReminderApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, String> tasks = new HashMap<>();
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nReminder App - Choose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Remove Task");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> editTask();
                case 3 -> removeTask();
                case 4 -> viewTasks();
                case 5 -> {
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        tasks.put(taskIdCounter, task);
        System.out.println("Task added with ID: " + taskIdCounter);
        taskIdCounter++;
    }

    private static void editTask() {
        viewTasks();
        System.out.print("Enter task ID to edit: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        if (tasks.containsKey(taskId)) {
            System.out.print("Enter new task description: ");
            String newTask = scanner.nextLine();
            tasks.put(taskId, newTask);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    private static void removeTask() {
        viewTasks();
        System.out.print("Enter task ID to remove: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        if (tasks.remove(taskId) != null) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            tasks.forEach((id, task) -> System.out.println(id + ". " + task));
        }
    }
}
