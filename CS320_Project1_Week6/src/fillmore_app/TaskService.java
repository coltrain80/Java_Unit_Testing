package fillmore_app;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks;
    
    // create our in memory storage, a HashMap
    public TaskService() {
        tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists.");
        }
        tasks.put(task.getTaskID(), task);
    }

    public void deleteTask(String taskID) {
    	// protect our delete method
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        tasks.remove(taskID);
    }

    public void updateTaskName(String taskID, String newName) {
    	// protect our update TaskName method
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        task.setTaskName(newName);
    }

    public void updateTaskDescription(String taskID, String newDescription) {
    	// protect our update TaskDescription method
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist.");
        }
        task.setTaskDescription(newDescription);
    }
    
    // need this for testing
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}



