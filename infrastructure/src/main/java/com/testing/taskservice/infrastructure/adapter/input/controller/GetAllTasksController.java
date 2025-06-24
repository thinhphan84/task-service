package com.testing.taskservice.infrastructure.adapter.input.controller;

import com.testing.taskservice.application.common.annotations.WebAdapter;
import com.testing.taskservice.application.dto.TaskDTO;
import com.testing.taskservice.application.port.input.GetAllTasksUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class GetAllTasksController {
    private final GetAllTasksUseCase getAllTasksUseCase;

    @GetMapping(path = "/tasks")
    ResponseEntity<List<TaskDTO>> getAllTaskUseCase() {
        return new ResponseEntity<>(getAllTasksUseCase.getAllTasks(null), HttpStatus.OK);
    }
}
