package com.spirng.security.springsecurity.domains.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter @Getter @Table(indexes = {
    @Index(name = "uk_secure_id", columnList = "secureId")
})
public abstract class AbstracBaseEntity implements Serializable {
    
    @Column(name = "secureId", nullable = false, unique = true)
    private String secureId = UUID.randomUUID().toString();

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;

    @Column(name = "deleted_at", nullable = true)
    private LocalDateTime deletedAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
}
