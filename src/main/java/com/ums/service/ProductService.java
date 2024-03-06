package com.ums.service;
import com.ums.dto.ProductDto;
import com.ums.entity.Product;
import com.ums.exception.CustomException;
import com.ums.repository.IProduct;
//import com.ums.utils.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private IProduct productRepo;


    public Product createProduct(Product productDetails) {
        return productRepo.save(productDetails);
    }

    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepo.findById(String.valueOf(productId));
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new CustomException("Product not found with ID: " + productId);
        }
    }
}