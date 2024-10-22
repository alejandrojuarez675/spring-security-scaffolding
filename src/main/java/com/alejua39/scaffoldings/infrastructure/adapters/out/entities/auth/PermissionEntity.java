package com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PermissionEntity {
    private Long id;
    private String name;
}
