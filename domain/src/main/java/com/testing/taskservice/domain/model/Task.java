package com.testing.taskservice.domain.model;


import com.testing.taskservice.domain.enums.TaskPriority;
import com.testing.taskservice.domain.enums.TaskStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    TaskId id;
    String title;
    String description;
    LocalDateTime dueDate;
    TaskStatus status;
    TaskPriority priority;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    Boolean isDeleted;

    public boolean isOverdue() {
        return dueDate != null && dueDate.isBefore(LocalDateTime.now()) && status != TaskStatus.COMPLETED;
    }

    public boolean isCompleted() {
        return status == TaskStatus.COMPLETED;
    }

    public record TaskId(UUID value) {
    }
}
