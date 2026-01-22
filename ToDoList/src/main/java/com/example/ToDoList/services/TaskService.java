package com.example.ToDoList.services;

import com.example.ToDoList.models.Tasks;
import com.example.ToDoList.repositories.TaskRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Tasks createNewTask(Tasks task) {
        return taskRepository.save(task);
    }

    public List<Tasks> getAllTask() {
        return taskRepository.findAll();
    }

    public Tasks findTaskById(Long id) {
        return taskRepository.getById(id);
    }

    public List<Tasks> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue();
    }

    public List<Tasks> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(Tasks task) {
        taskRepository.delete(task);
    }

    public @Nullable Tasks updateTask(Tasks task) {
        return taskRepository.save(task);
    }
}