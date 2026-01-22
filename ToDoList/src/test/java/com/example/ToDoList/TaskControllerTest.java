package com.example.ToDoList;

import com.example.ToDoList.controllers.HomeController;
import com.example.ToDoList.models.Tasks;
import com.example.ToDoList.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TaskService taskService;

    @Test
    void getAllTasks_ShouldReturnOk() throws Exception {
        when(taskService.getAllTask()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/tasks/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        verify(taskService).getAllTask();
    }

    @Test
    void postTask_ShouldReturnCreated() throws Exception {
        Tasks task = new Tasks();
        task.setTask("New Task");
        when(taskService.createNewTask(any(Tasks.class))).thenReturn(task);

        mockMvc.perform(post("/api/v1/tasks/")
                        .contentType("application/json")
                        .content("{\"task\":\"New Task\",\"completed\":false}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.task").value("New Task"));

        verify(taskService).createNewTask(any(Tasks.class));
    }
}
