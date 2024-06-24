package com.NalenWebsite.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductListDTO {
    private Long id;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private String productImagePath;
}
