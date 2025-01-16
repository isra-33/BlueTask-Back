package com.example.demo.Interface;

import com.example.demo.Enum.Status;
import com.example.demo.Enum.Type;
import com.example.demo.entity.Task;

import java.util.*;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);
    List<Task> getTasksByStatus(Status status);
    List<Task> getTasksByType(Type type);


}
