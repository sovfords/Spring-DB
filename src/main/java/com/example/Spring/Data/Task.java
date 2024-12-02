package com.example.Spring.Data;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;
    private TaskStatus taskStatus;
    private LocalDateTime dateTime;

    public Task(String text) {
        this.text = text;
        taskStatus = TaskStatus.NOT_STARTED;
        dateTime = LocalDateTime.now();
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}

 enum TaskStatus
{
    NOT_STARTED("не начата"),
    IN_PROGRESS("в процессе"),
    COMPLETED("завершена");

    private String title;

    TaskStatus(String title)
    {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
