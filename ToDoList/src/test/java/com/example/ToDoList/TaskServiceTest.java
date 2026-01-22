package com.example.ToDoList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ToDoList.models.Tasks;
import com.example.ToDoList.repositories.TaskRepository;

import com.example.ToDoList.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;


public class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateNewTask() {
        Tasks task = new Tasks();
        task.setTask("Test");
        when(taskRepository.save(task)).thenReturn(task);

        Tasks result = taskService.createNewTask(task);
        assertNotNull(result);
        assertEquals("Test", result.getTask());
        verify(taskRepository).save(task);
    }

    @Test
    void testGetAllTasks() {
        taskService.getAllTask();
        verify(taskRepository).findAll();
    }
}

