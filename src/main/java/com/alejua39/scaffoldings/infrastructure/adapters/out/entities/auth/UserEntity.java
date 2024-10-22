package com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth;

import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {

    private Long id;
    private String username;
    private String password;
    private boolean isEnabled;
    private boolean accountNoExpired;
    private boolean accountNoLocked;
    private boolean credentialNoExpired;
    private Set<RoleEntity> roles;
}
