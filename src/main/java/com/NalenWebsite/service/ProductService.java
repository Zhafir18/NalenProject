package com.NalenWebsite.service;

import com.NalenWebsite.dto.Product.ProductListDTO;
import com.NalenWebsite.dto.Product.UpsertProductDTO;
import com.NalenWebsite.entity.Products;
import com.NalenWebsite.repository.ProductRepository;
import com.NalenWebsite.utility.Helper.FileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductListDTO> getAllProducts(String productName) {
        return productRepository.getAllProductListDTO(productName);
    }

    public List<ProductListDTO> getProductList(Long categoryId, String productName) {
        return productRepository.getProductListByCategory(categoryId, productName);
    }

    public void productImageHandler(UpsertProductDTO dto) {
        var multipartFile = dto.getProductImageFile();
        var isMultipartEmpty = multipartFile.isEmpty();
        var path = (Optional.ofNullable(dto.getProductImagePath()).orElse("").isEmpty() && isMultipartEmpty)
                ? null : dto.getProductImagePath();
        try {
            if (!isMultipartEmpty) {
                path = FileHelper.uploadProductImage(path, multipartFile);
            }
            dto.setProductImagePath(path);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
        }
    }

    public void upsertProduct(UpsertProductDTO dto) {
        var entity = new Products();
        entity.setProductId(dto.getId());
        entity.setProductName(dto.getProductName());
        entity.setProductDescription(dto.getProductDescription());
        entity.setPrice(dto.getProductPrice());

        productImageHandler(dto);
        entity.setImagePath(dto.getProductImagePath());
        entity.setCategoryId(dto.getCategoryId());
        productRepository.save(entity);
    }
}
