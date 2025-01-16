package com.example.demo.controller;

import com.example.demo.Enum.Status;
import com.example.demo.Enum.Type;
import com.example.demo.Interface.TaskService;
import com.example.demo.entity.Task;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/tasks")
@Validated
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create a new task
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    // Get all tasks
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        // Use the username as needed
        return ResponseEntity.ok(taskService.getAllTasks());
    }


    // Update a task
    @CrossOrigin(origins = "http://localhost:4200")

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task taskDetails) {
        return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
    }

    // Delete a task
    @CrossOrigin(origins = "http://localhost:4200")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // Get tasks by status (completed or not completed)
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable Status status) {
        return ResponseEntity.ok(taskService.getTasksByStatus(status));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Task>> getTasksByType(@PathVariable Type type) {
        return ResponseEntity.ok(taskService.getTasksByType(type));
    }

}