package com.bridgelabz.user_service.exception;


import com.bridgelabz.common_library.dto.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception ex) {
        return new ApiResponse<>(false, ex.getMessage(), null);
    }
}