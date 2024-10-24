package com.alejua39.scaffoldings.infrastructure.adapters.out.repositories.impl;

import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEntity;
import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEnum;
import com.alejua39.scaffoldings.infrastructure.adapters.out.repositories.RoleRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class MockedRoleRepository implements RoleRepository {

    @Override
    public Collection<RoleEntity> findRoleEntitiesByRoleEnumIn(List<String> rolesRequest) {
        return rolesRequest.stream()
                .map(RoleEnum::fromString)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(x -> RoleEntity.builder()
                        .roleEnum(x)
                        .permissionList(Set.of())
                        .build())
                .collect(Collectors.toList());
    }
}
