package com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleEntity {
    private Long id;
    private RoleEnum roleEnum;
    private Set<PermissionEntity> permissionList;
}
