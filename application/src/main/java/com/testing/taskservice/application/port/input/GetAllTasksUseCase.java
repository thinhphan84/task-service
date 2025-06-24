package com.testing.taskservice.application.port.input;

import com.testing.taskservice.application.dto.TaskDTO;

import java.util.List;

public interface GetAllTasksUseCase {
    List<TaskDTO> getAllTasks(GetAllTasksUseCaseQuery query);

    record GetAllTasksUseCaseQuery() {

    }
}
