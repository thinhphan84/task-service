package com.testing.taskservice.infrastructure.adapter.input.controller;

import com.testing.taskservice.application.common.annotations.WebAdapter;
import com.testing.taskservice.application.dto.TaskDTO;
import com.testing.taskservice.application.port.input.GetAllTasksUseCase;
import com.testing.taskservice.application.port.input.GetAllTasksUseCase.GetAllTasksUseCaseQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetAllTasksController {
    private final GetAllTasksUseCase getAllTasksUseCase;

    @GetMapping(path = "/tasks")
    ResponseEntity<Page<TaskDTO>> getAllTaskUseCase(@PageableDefault Pageable pageable) {
        GetAllTasksUseCaseQuery getAllTasksUseCaseQuery = new GetAllTasksUseCaseQuery(pageable);
        return new ResponseEntity<>(getAllTasksUseCase.getAllByIsDeletedFalse(getAllTasksUseCaseQuery), HttpStatus.OK);
    }
}
