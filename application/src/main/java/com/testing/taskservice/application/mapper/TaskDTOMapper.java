package com.testing.taskservice.application.mapper;

import com.testing.taskservice.application.dto.TaskDTO;
import com.testing.taskservice.domain.enums.TaskPriority;
import com.testing.taskservice.domain.enums.TaskStatus;
import com.testing.taskservice.domain.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskDTOMapper {

    public TaskDTO mapToDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId().value());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setPriority(task.getPriority().toString());
        dto.setStatus(task.getStatus().toString());
        dto.setDueDate(task.getDueDate());
        dto.setIsDeleted(task.getIsDeleted());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdatedAt(task.getUpdatedAt());
        return dto;
    }

    public Task mapToDomainModel(TaskDTO dto) {
        return Task.builder()
                .id(new Task.TaskId(dto.getId()))
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(TaskPriority.valueOf(dto.getPriority()))
                .status(TaskStatus.valueOf(dto.getStatus()))
                .dueDate(dto.getDueDate())
                .isDeleted(dto.getIsDeleted())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
}
