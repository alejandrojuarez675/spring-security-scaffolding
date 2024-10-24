package com.alejua39.scaffoldings.infrastructure.adapters.out.entities.auth;

import java.util.Optional;

public enum RoleEnum {
    SUPER_ADMIN,
    ADMIN,
    BUYER;

    public static Optional<RoleEnum> fromString(String role) {
        try {
            return Optional.of(RoleEnum.valueOf(role));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}
