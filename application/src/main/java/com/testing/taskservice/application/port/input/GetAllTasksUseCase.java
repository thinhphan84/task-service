package com.testing.taskservice.application.port.input;

import com.testing.taskservice.application.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllTasksUseCase {
    Page<TaskDTO> getAllByIsDeletedFalse(GetAllTasksUseCaseQuery query);

    record GetAllTasksUseCaseQuery(Pageable pageable) {

    }

    String getData();


}
