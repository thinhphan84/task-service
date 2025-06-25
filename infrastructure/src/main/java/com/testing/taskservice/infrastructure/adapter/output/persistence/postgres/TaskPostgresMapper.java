package com.testing.taskservice.infrastructure.adapter.output.persistence.postgres;

import com.testing.taskservice.domain.enums.TaskPriority;
import com.testing.taskservice.domain.enums.TaskStatus;
import com.testing.taskservice.domain.model.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TaskPostgresMapper {
    Task mapToDomainEntity(TaskPostgresEntity taskPostgresEntity) {
        return Task.builder().id(new Task.TaskId(taskPostgresEntity.getId())).
                title(taskPostgresEntity.getTitle()).
                description(taskPostgresEntity.getDescription()).
                priority(TaskPriority.valueOf(taskPostgresEntity.getPriority())).
                status(TaskStatus.valueOf(taskPostgresEntity.getStatus())).
                dueDate(taskPostgresEntity.getDueDate().toLocalDateTime()).
                isDeleted(taskPostgresEntity.getIsDeleted()).
                createdAt(taskPostgresEntity.getCreatedAt().toLocalDateTime()).
                updatedAt(taskPostgresEntity.getUpdatedAt().toLocalDateTime()).build();
    }

    TaskPostgresEntity mapToPostgresEntity(Task task) {
        TaskPostgresEntity taskPostgresEntity = new TaskPostgresEntity();
        BeanUtils.copyProperties(task, taskPostgresEntity);
        return taskPostgresEntity;
    }
}
