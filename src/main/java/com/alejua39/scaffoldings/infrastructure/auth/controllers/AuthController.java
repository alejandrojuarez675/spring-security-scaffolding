package com.alejua39.scaffoldings.infrastructure.auth.controllers;

import com.alejua39.scaffoldings.infrastructure.auth.dtos.AuthCreateUserRequest;
import com.alejua39.scaffoldings.infrastructure.auth.dtos.AuthLoginRequest;
import com.alejua39.scaffoldings.infrastructure.auth.dtos.AuthResponse;
import com.alejua39.scaffoldings.infrastructure.auth.service.UserDetailServiceImpl;
import jakarta.validation.Valid;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserDetailServiceImpl userDetailService;

    public AuthController(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid AuthCreateUserRequest userRequest) {
        try {
            return new ResponseEntity<>(this.userDetailService.createUser(userRequest), HttpStatus.CREATED);
        } catch (BadRequestException | IllegalArgumentException e) {
            return new ResponseEntity<>(
                    new AuthResponse(userRequest.username(), e.getMessage(), null, false),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailService.loginUser(userRequest), HttpStatus.OK);
    }
}
