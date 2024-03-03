package fillmore_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class TaskServiceTest {

    @Test
    @DisplayName("Test that adding a valid taskID succeeds")
    public void testAddValidTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        service.addTask(task);
        
        assertEquals(task, service.getTask("1"));
    }

    @Test
    @DisplayName("Test that adding a null taskID throws an exception")
    public void testAddNullTask() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(null);
        });
    }

    @Test
    @DisplayName("Test that adding a duplicate taskID throws an expception")
    public void testAddDuplicateTaskID() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "TaskName", "TaskDescription"));
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(new Task("1", "TaskName", "TaskDescription"));
        });
    }

    @Test
    @DisplayName("Test that deleting a valid task is successful")
    public void testDeleteValidTask() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "TaskName", "TaskDescription"));
        
        service.deleteTask("1");
        
        assertNull(service.getTask("1"));
    }

    @Test
    @DisplayName("Test that deleting an invalid task throws an exception")
    public void testDeleteInvalidTask() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("1");
        });
    }

    @Test
    @DisplayName("Test that updating task name with a valid name is successful")
    public void testUpdateValidTaskName() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "TaskName", "TaskDescription"));
        service.updateTaskName("1", "NewName");
        
        Task updatedTask = service.getTask("1");
        
        assertNotNull(updatedTask);
        assertEquals("NewName", updatedTask.getTaskName());
    }
    
    @Test
    @DisplayName("Test that updating task name for a taskID that doesn't exist throws an exception")
    public void testUpdateNonExistentTaskName() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("nonexistent", "NewName"));
    }

    @Test
    @DisplayName("Test that updating a task description with a valid description is successful")
    public void testUpdateValidTaskDescription() {
        TaskService service = new TaskService();
        service.addTask(new Task("1", "TaskName", "TaskDescription"));
        service.updateTaskDescription("1", "NewDescription");
        
        Task updatedTask = service.getTask("1");
        
        assertNotNull(updatedTask);
        assertEquals("NewDescription", updatedTask.getTaskDescription());
    }
    
    @Test
    @DisplayName("Test that updating a task description for a task that doesn't exist throws an exception")
    public void testUpdateNonExistentTaskDescription() {
        TaskService service = new TaskService();
        
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskDescription("nonexistent", "NewDescription"));
    }    
}
