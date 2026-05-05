package com.bridgelabz.product_service.controller;




import com.bridgelabz.common_library.dto.ApiResponse;
import com.bridgelabz.product_service.entity.Product;
import com.bridgelabz.product_service.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<?> create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping
    public ApiResponse<?> getAll() {
        return service.getAll();
    }

    // ✅ ADD THIS (GET BY ID)
    @GetMapping("/{id}")
    public ApiResponse<?> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/reduce-stock/{id}")
    public ApiResponse<?> reduceStock(
            @PathVariable Long id,
            @RequestParam int quantity
    ) {
        return service.reduceStock(id, quantity);
    }
}