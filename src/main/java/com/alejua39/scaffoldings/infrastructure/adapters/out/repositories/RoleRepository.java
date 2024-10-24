package com.alejua39.scaffoldings.infrastructure.adapters.out.repositories;

import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEntity;
import java.util.Collection;
import java.util.List;

public interface RoleRepository {
    Collection<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> rolesRequest);
}
