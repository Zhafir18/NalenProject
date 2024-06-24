package com.NalenWebsite.service;

import com.NalenWebsite.dto.Product.ProductListDTO;
import com.NalenWebsite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductListDTO> getAllProducts(String productName) {
        var data = productRepository.getAllProductListDTO(productName);
        return data;
    }

    public List<ProductListDTO> getProductList(Long categoryId, String productName) {
        var data = productRepository.getProductListByCategory(categoryId, productName);
        return data;
    }
}
