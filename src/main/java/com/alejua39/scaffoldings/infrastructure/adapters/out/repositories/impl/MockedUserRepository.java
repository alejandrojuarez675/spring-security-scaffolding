package com.alejua39.scaffoldings.infrastructure.adapters.out.repositories.impl;

import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEntity;
import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEnum;
import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.UserEntity;
import com.alejua39.scaffoldings.infrastructure.adapters.out.repositories.UserRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class MockedUserRepository implements UserRepository {

    private static final Set<UserEntity> mockedUsers = new HashSet<>();

    public MockedUserRepository() {
        mockedUsers.add(UserEntity.builder()
                        .id(1L)
                        .username("superadmin")
                        .password(new BCryptPasswordEncoder().encode("superadmin"))
                        .roles(Set.of(
                                RoleEntity.builder()
                                        .roleEnum(RoleEnum.SUPER_ADMIN)
                                        .permissionList(Set.of())
                                        .build(),
                                RoleEntity.builder()
                                        .roleEnum(RoleEnum.ADMIN)
                                        .permissionList(Set.of())
                                        .build(),
                                RoleEntity.builder()
                                        .roleEnum(RoleEnum.BUYER)
                                        .permissionList(Set.of())
                                        .build()))
                        .isEnabled(true)
                        .accountNoExpired(true)
                        .accountNoLocked(true)
                        .credentialNoExpired(true)
                        .build());

        mockedUsers.add(UserEntity.builder()
                        .id(1L)
                        .username("admin")
                        .password(new BCryptPasswordEncoder().encode("admin"))
                        .roles(Set.of(RoleEntity.builder()
                                .roleEnum(RoleEnum.ADMIN)
                                .permissionList(Set.of())
                                .build()))
                        .isEnabled(true)
                        .accountNoExpired(true)
                        .accountNoLocked(true)
                        .credentialNoExpired(true)
                        .build());

        mockedUsers.add(UserEntity.builder()
                        .id(1L)
                        .username("buyer")
                        .password(new BCryptPasswordEncoder().encode("buyer"))
                        .roles(Set.of(RoleEntity.builder()
                                .roleEnum(RoleEnum.BUYER)
                                .permissionList(Set.of())
                                .build()))
                        .isEnabled(true)
                        .accountNoExpired(true)
                        .accountNoLocked(true)
                        .credentialNoExpired(true)
                        .build());
    }

    @Override
    public Optional<UserEntity> findUserEntityByUsername(String username) {
        return MockedUserRepository.mockedUsers.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        mockedUsers.add(userEntity);
        return userEntity;
    }
}
