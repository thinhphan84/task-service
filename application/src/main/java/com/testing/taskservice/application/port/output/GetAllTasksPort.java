package com.testing.taskservice.application.port.output;

import com.testing.taskservice.domain.model.Task;

import java.util.List;

public interface GetAllTasksPort {
    List<Task> getAllTasks();
}
