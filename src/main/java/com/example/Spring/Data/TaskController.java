package com.example.Spring.Data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public Task addTask(@RequestBody String text)
    {
        Task task = new Task(text);
        taskService.createTask(task);
        return task;
    }

    @GetMapping("/get/all")
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
    {
        return taskService.getTasksByStatus(status);
    }

    @PutMapping("/{id}/{status}")
    public Task updateTaskStatus(@PathVariable Long id, @PathVariable TaskStatus status){
        return taskService.updateTaskStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id)
    {
        taskService.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

}
