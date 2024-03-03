package fillmore_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

public class TaskTest {

    @Test
    @DisplayName("Test that creating a Task object with all valid parameters succeeds")
    public void testValidTaskCreation() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        assertEquals("1", task.getTaskID());
        assertEquals("TaskName", task.getTaskName());
        assertEquals("TaskDescription", task.getTaskDescription());
    }

    @Test
    @DisplayName("Test that creating a Task object with null TaskId throws exception")
    public void testNullTaskIdTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "TaskName", "TaskDescription");
        });
    }
    
    @Test
    @DisplayName("Test that creating a Task object with an TaskID longer than 10 characters throws an exception")
    public void testLongTaskIdCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "TaskName", "TaskDescription"); // 11 characters
        });
    }

    @Test
    @DisplayName("Test that creating a Task object with a null TaskName throws exception")
    public void testNullNameTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", null, "TaskDescription");
        });
    }
    
    @Test
    @DisplayName("Test that creating a Task object with a TaskName longer than 20 characters throws an exception")
    public void testLongNameTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "ThisNameIsWayTooLong1234567891", "TaskDescription");
        });
    }

    @Test
    @DisplayName("Test that creating a Task object with an null TaskDescription throws an exception")
    public void testNullDescriptionTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "TaskName", null);
        });
    }
    
    @Test
    @DisplayName("Test that creating a Task object with a TaskDescription longer than 50 characters throws an exception")
    public void testLongDescriptionTaskCreation() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "TaskName", "ThisDescriptionIsWayTooLong123456789123456789123456789");
        });
    }
    
    @Test
    @DisplayName("Test that setting a valid TaskName succeeds")
    public void testSetValidTaskName() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        task.setTaskName("NewName");
        
        assertEquals("NewName", task.getTaskName());
    }
    
    @Test
    @DisplayName("Test that setting a null TaskName throws an exception")
    public void testSetNullTaskName() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName(null);
        });
    }
    
    @Test
    @DisplayName("Test that setting a TaskName longer than 20 characters throws an exception")
    public void testSetLongTaskName() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskName("NewNameWayTooLong1234");
        });
    }

    @Test
    @DisplayName("Test that setting a valid TaskDescription succeeds")
    public void testSetValidTaskDescription() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        task.setTaskDescription("NewDescription");
        
        assertEquals("NewDescription", task.getTaskDescription());
    }

    @Test
    @DisplayName("Test that setting an null TaskDescription throws an exception")
    public void testSetNullTaskDescription() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription(null);
        });
    }
    
    @Test
    @DisplayName("Test that setting a TaskDescription longer than 50 characters throws an exception")
    public void testSetLongTaskDescription() {
        Task task = new Task("1", "TaskName", "TaskDescription");
        
        assertThrows(IllegalArgumentException.class, () -> {
            task.setTaskDescription("NewDescriptionWayTooLong123456789123456789123456789");
        });
    }
}
