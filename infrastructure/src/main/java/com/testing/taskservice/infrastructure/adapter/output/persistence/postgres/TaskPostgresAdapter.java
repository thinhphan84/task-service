package com.testing.taskservice.infrastructure.adapter.output.persistence.postgres;

import com.testing.taskservice.application.common.annotations.PersistenceAdapter;
import com.testing.taskservice.application.port.output.GetAllTasksPort;
import com.testing.taskservice.domain.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@PersistenceAdapter
@RequiredArgsConstructor
public class TaskPostgresAdapter implements GetAllTasksPort {
    private final TaskPostgresRepository taskPostgresRepository;
    private final TaskPostgresMapper taskPostgresMapper;

    @Override
    public Page<Task> getAllByIsDeletedFalse(Pageable pageable) {
        Page<Task> page = taskPostgresRepository.getAllByIsDeletedFalse(pageable)
                .map(taskPostgresMapper::mapToDomainModel);

        System.out.println(page);
        return page;
    }

}
