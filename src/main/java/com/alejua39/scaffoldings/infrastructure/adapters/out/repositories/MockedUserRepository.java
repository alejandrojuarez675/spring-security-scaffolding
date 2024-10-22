package com.alejua39.scaffoldings.infrastructure.adapters.out.repositories;

import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEntity;
import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.RoleEnum;
import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.UserEntity;
import java.util.Optional;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class MockedUserRepository implements UserRepository {

    private final PasswordEncoder passwordEncoder;

    public MockedUserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private Set<UserEntity> getMockedUsers() {
        return Set.of(
                UserEntity.builder()
                        .id(1L)
                        .username("superadmin")
                        .password(this.passwordEncoder.encode("superadmin"))
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
                        .build(),

                UserEntity.builder()
                        .id(1L)
                        .username("admin")
                        .password(this.passwordEncoder.encode("admin"))
                        .roles(Set.of(RoleEntity.builder()
                                .roleEnum(RoleEnum.ADMIN)
                                .permissionList(Set.of())
                                .build()))
                        .isEnabled(true)
                        .accountNoExpired(true)
                        .accountNoLocked(true)
                        .credentialNoExpired(true)
                        .build(),

                UserEntity.builder()
                        .id(1L)
                        .username("buyer")
                        .password(this.passwordEncoder.encode("buyer"))
                        .roles(Set.of(RoleEntity.builder()
                                .roleEnum(RoleEnum.BUYER)
                                .permissionList(Set.of())
                                .build()))
                        .isEnabled(true)
                        .accountNoExpired(true)
                        .accountNoLocked(true)
                        .credentialNoExpired(true)
                        .build()
        );
    }

    @Override
    public Optional<UserEntity> findUserEntityByUsername(String username) {
        return getMockedUsers().stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
}
