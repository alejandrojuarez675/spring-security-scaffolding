package com.alejua39.scaffoldings.infrastructure.auth.dtos;

public record AuthResponse(
        String username,
        String message,
        String jwt,
        Boolean status
) {
}
