package com.example.Spring.Data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class TaskService
{
    @Autowired
    private TaskRepository repository;

    public void createTask(Task task) {
        repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        List<Task> tasks = getAllTasks();
        List<Task> sortedTasks = new ArrayList<>();
        for(Task task: tasks)
        {
            if(task.getTaskStatus() == status)
            {
                sortedTasks.add(task);
            }
        }

        return sortedTasks;

    }

    public Task updateTaskStatus(Long id,TaskStatus status) {
           Task task = repository.findById(id).orElse(null);
           task.setTaskStatus(status);
           repository.save(task);
           return task;
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }








}
