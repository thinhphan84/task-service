package com.testing.taskservice.application.service;


import com.testing.taskservice.application.common.annotations.UseCase;
import com.testing.taskservice.application.dto.TaskDTO;
import com.testing.taskservice.application.mapper.TaskDTOMapper;
import com.testing.taskservice.application.port.input.GetAllTasksUseCase;
import com.testing.taskservice.application.port.output.GetAllTasksPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional(readOnly = true)
public class GetAllTasksService implements GetAllTasksUseCase {
    private final GetAllTasksPort getAllTasksPort;
    private final TaskDTOMapper taskDTOMapper;

    @Override
    public Page<TaskDTO> getAllByIsDeletedFalse(GetAllTasksUseCaseQuery query) {
        return getAllTasksPort.getAllByIsDeletedFalse(query.pageable())
                .map(taskDTOMapper::mapToDTO);
    }
}
