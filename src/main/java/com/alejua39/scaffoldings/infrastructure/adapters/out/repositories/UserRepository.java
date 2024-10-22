package com.alejua39.scaffoldings.infrastructure.adapters.out.repositories;

import com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth.UserEntity;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findUserEntityByUsername(String username);
}
