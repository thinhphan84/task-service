package com.testing.taskservice.application.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TaskDTO {
    UUID id;
    String title;
    String description;
    LocalDateTime dueDate;
    String status;
    String priority;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Boolean isDeleted;
}
