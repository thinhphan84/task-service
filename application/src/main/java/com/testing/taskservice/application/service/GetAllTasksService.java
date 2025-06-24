package com.testing.taskservice.application.service;


import com.testing.taskservice.application.common.annotations.UseCase;
import com.testing.taskservice.application.dto.TaskDTO;
import com.testing.taskservice.application.port.input.GetAllTasksUseCase;
import com.testing.taskservice.application.port.output.GetAllTasksPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@UseCase
@Transactional
public class GetAllTasksService implements GetAllTasksUseCase {
    private final GetAllTasksPort getAllTasksPort;

    @Override
    public List<TaskDTO> getAllTasks(GetAllTasksUseCaseQuery query) {
        return getAllTasksPort.getAllTasks().stream()
                .map(task -> {
                    TaskDTO taskDTO = new TaskDTO();
                    taskDTO.setId(task.getId().value());
                    taskDTO.setDescription(task.getDescription());
                    taskDTO.setPriority(task.getPriority().toString());
                    taskDTO.setStatus(task.getStatus().toString());
                    taskDTO.setDueDate(task.getDueDate());
                    taskDTO.setIsDeleted(task.getIsDeleted());
                    taskDTO.setCreatedAt(task.getCreatedAt());
                    taskDTO.setUpdatedAt(task.getUpdatedAt());
                    return taskDTO;
                })
                .collect(Collectors.toList());
    }

}
