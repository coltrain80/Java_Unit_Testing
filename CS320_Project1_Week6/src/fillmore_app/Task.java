package fillmore_app;

public class Task {
    private final String taskID;
    private String taskName;
    private String taskDescription;
    
    // define our class object with our required 3 parameters
    public Task(String taskID, String taskName, String taskDescription) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null and must be 10 characters or less.");
        }
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Task Name cannot be null and must be 20 characters or less.");
        }
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Task Description cannot be null and must be 50 characters or less.");
        }
        // set each of our class object attributes
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }
    
    // Gettors
    public String getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }
    
    public String getTaskDescription() {
        return taskDescription;
    }
    
    // Settors
    public void setTaskName(String taskName) {
        if (taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Task Name cannot be null and must be 20 characters or less.");
        }
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Task Description cannot be null and must be 50 characters or less.");
        }
        this.taskDescription = taskDescription;
    }
}
