package com.bridgelabz.user_service.service;

import com.bridgelabz.common_library.dto.ApiResponse;
import com.bridgelabz.user_service.client.ProductClient;
import com.bridgelabz.user_service.dto.*;
import com.bridgelabz.user_service.entity.User;
import com.bridgelabz.user_service.mapper.UserMapper;
import com.bridgelabz.user_service.repository.UserRepository;
import com.bridgelabz.user_service.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder;
    private final ProductClient productClient;

    // ✅ REGISTER
    @Override
    public ApiResponse<?> register(UserRequestDTO dto) {

        User user = UserMapper.toEntity(dto);

        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole("USER");

        repository.save(user);

        return new ApiResponse<>(true, "User created", user);
    }

    // ✅ LOGIN
    @Override
    public ApiResponse<?> login(LoginRequestDTO dto) {

        User user = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            return new ApiResponse<>(false, "Invalid credentials", null);
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());

        return new ApiResponse<>(true, "Login success", token);
    }

    // ✅ GET ALL USERS
    @Override
    public ApiResponse<?> getAllUsers() {
        return new ApiResponse<>(true, "Users fetched", repository.findAll());
    }

    // ✅ FEIGN CALL
    @Override
    public ApiResponse<?> getProductsFromUserService() {
        return productClient.getAllProducts();
    }

    // ✅ DELETE
    @Override
    public ApiResponse<?> deleteUser(Long id) {

        if (!repository.existsById(id)) {
            return new ApiResponse<>(false, "User not found", null);
        }

        repository.deleteById(id);

        return new ApiResponse<>(true, "User deleted", null);
    }

    // 🔥 VERY IMPORTANT METHOD (FOR ORDER SERVICE)
    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}