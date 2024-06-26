package com.NalenWebsite.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpsertProductDTO {
    private Long id;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Long categoryId;
    private String productImagePath;
    private MultipartFile productImageFile;

    public UpsertProductDTO(Long id, String productName, String productDescription, Double productPrice, Long categoryId, String productImagePath) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.categoryId = categoryId;
        this.productImagePath = productImagePath;
    }
}
