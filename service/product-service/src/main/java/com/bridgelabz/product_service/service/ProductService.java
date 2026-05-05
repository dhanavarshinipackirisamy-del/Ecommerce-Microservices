package com.bridgelabz.product_service.service;


import com.bridgelabz.common_library.dto.ApiResponse;
import com.bridgelabz.product_service.entity.Product;
public interface ProductService {

    ApiResponse<?> create(Product product);

    ApiResponse<?> getAll();
    ApiResponse<?> getById(Long id);
    ApiResponse<?> reduceStock(Long id, int quantity);
}