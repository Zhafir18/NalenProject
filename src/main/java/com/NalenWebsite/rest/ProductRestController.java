package com.NalenWebsite.rest;

import com.NalenWebsite.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Object> getAllProducts(@RequestParam(required = false) String productName) {
        var data = productService.getAllProducts(productName);
        return ResponseEntity.status(200).body(data);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Object> getProductByCategoryId(@PathVariable Long categoryId,
                                                         @RequestParam(required = false) String productName) {
        var data = productService.getProductList(categoryId, productName);
        return ResponseEntity.status(200).body(data);
    }
}
