package com.testing.taskservice.infrastructure.adapter.output.persistence.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskPostgresRepository extends JpaRepository<TaskPostgresEntity, UUID> {

}
