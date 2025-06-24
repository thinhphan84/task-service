package com.testing.taskservice.infrastructure.adapter.output.persistence.postgres;

import com.testing.taskservice.domain.model.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TaskPostgresMapper {
    Task mapToDomainEntity(TaskPostgresEntity taskPostgresEntity) {
        Task task = Task.builder().build();
        BeanUtils.copyProperties(taskPostgresEntity, task);
        return task;
    }

    TaskPostgresEntity mapToPostgresEntity(Task task) {
        TaskPostgresEntity taskPostgresEntity = new TaskPostgresEntity();
        BeanUtils.copyProperties(task, taskPostgresEntity);
        return taskPostgresEntity;
    }
}
