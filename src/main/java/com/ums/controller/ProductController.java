package com.ums.controller;
import com.ums.service.ProductService;
import com.ums.entity.Product;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
@RestController
@Validated
public class ProductController {
    private static final Logger log = LogManager.getLogger(com.ums.controller.ProductController.class);
    @Autowired
    ProductService productService;
    @PostMapping("/create")
    public Product createproduct(@Valid @RequestBody Product productDetails)
    {
        log.info("Product creation API is called!");
        return productService.createProduct(productDetails);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        log.info("Fetching product details for productId: " + productId);
        return productService.getProductById(productId);

    }
}