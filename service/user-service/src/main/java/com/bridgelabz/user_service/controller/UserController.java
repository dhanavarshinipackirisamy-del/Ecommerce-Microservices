package com.bridgelabz.user_service.controller;

import com.bridgelabz.common_library.dto.ApiResponse;
import com.bridgelabz.user_service.dto.*;
import com.bridgelabz.user_service.entity.User;
import com.bridgelabz.user_service.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 🔹 REGISTER
    @PostMapping
    public ApiResponse<?> register(@Valid @RequestBody UserRequestDTO dto) {
        return userService.register(dto);
    }

    // 🔹 GET ALL USERS
    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    public ApiResponse<?> getAllUsers() {
        return userService.getAllUsers();
    }

    // 🔹 LOGIN
    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequestDTO dto) {
        return userService.login(dto);
    }

    // 🔥 VERY IMPORTANT (FIX FOR ORDER SERVICE)
    @GetMapping("/email/{email}")
    public ApiResponse<?> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        return new ApiResponse<>(true, "User found", user);
    }

    // 🔹 DELETE USER
    @DeleteMapping("/delete/{id}")
    public ApiResponse<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ApiResponse<>(true, "User deleted", null);
    }
}