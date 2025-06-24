package com.testing.taskservice.infrastructure.adapter.output.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
class TaskPostgresEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "due_date")
    private OffsetDateTime dueDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Size(max = 20)
    @NotNull
    @Column(name = "priority", nullable = false, length = 20)
    private String priority;

    @Size(max = 20)
    @NotNull
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Size(max = 255)
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}
