package com.example.ToDoList.repositories;

import com.example.ToDoList.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{
    public Tasks findByTask(String task);
    public List<Tasks> findByCompletedTrue();
    public List<Tasks> findByCompletedFalse();
    public List<Tasks> findAll();
    public Tasks getById(Long id);

}
