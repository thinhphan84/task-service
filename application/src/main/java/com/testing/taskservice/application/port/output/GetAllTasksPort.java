package com.testing.taskservice.application.port.output;

import com.testing.taskservice.domain.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetAllTasksPort {
    Page<Task> getAllByIsDeletedFalse(Pageable pageable);
}
