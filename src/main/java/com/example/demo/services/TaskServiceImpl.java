package com.example.demo.services;

import com.example.demo.Enum.Status;
import com.example.demo.Enum.Type;
import com.example.demo.Interface.TaskService;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        task.setTitle(taskDetails.getTitle());
        task.setStatus(taskDetails.getStatus());  // Assuming status is an enum, no need to use isStatus() for enum
        task.setType(taskDetails.getType());  // Updating the task type
        return taskRepository.save(task);
    }


    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByStatus(Status status) {
        return taskRepository.findByStatus(status);  // Assuming you have a status field that can be queried by boolean
    }

    @Override
    public List<Task> getTasksByType(Type type) {
        return taskRepository.findByType(type);
    }

}
