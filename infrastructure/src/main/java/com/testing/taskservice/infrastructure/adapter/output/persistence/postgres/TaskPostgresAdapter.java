package com.testing.taskservice.infrastructure.adapter.output.persistence.postgres;

import com.testing.taskservice.application.common.annotations.PersistenceAdapter;
import com.testing.taskservice.application.port.output.GetAllTasksPort;
import com.testing.taskservice.domain.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@PersistenceAdapter
@RequiredArgsConstructor
public class TaskPostgresAdapter implements GetAllTasksPort {
    private final TaskPostgresRepository taskPostgresRepository;
    private final TaskPostgresMapper taskPostgresMapper;

    @Override
    public List<Task> getAllTasks() {
        return taskPostgresRepository.findAll().stream()
                .map(taskPostgresMapper::mapToDomainEntity)
                .collect(Collectors.toList());
    }
}
