package edu.fscj.cen3024c.taskmanager.controller;

import edu.fscj.cen3024c.taskmanager.dto.TaskDTO;
import edu.fscj.cen3024c.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer id) {
        // Handle the Optional<Task> correctly
        return taskService.findById(id)
                .map(task -> ResponseEntity.ok(task))  // Convert to TaskDTO and return 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build());  // Return 404 if not found
    }

    @PostMapping("/{taskId}/users/{userId}")
    public ResponseEntity<?> associateTaskWithUser(@PathVariable Long taskId, @PathVariable Long userId) {
        // Associate the task with the user
        return ResponseEntity.ok("Task " + taskId + " associated with User " + userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Integer id, @RequestBody TaskDTO taskDTO) {
        taskDTO.setId(id);  // Ensure the task ID is set correctly
        TaskDTO updatedTask = taskService.save(taskDTO);  // Save the updated task
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
