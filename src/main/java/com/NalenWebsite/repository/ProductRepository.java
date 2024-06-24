package com.NalenWebsite.repository;

import com.NalenWebsite.dto.Product.ProductListDTO;
import com.NalenWebsite.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {

    @Query("""
           SELECT new com.NalenWebsite.dto.Product.ProductListDTO
           (
                p.productId,
                p.productName,
                p.productDescription,
                p.price,
                p.imagePath
           )
           FROM Products p
           WHERE (:productName IS NULL OR p.productName LIKE %:productName%)
           """)
    public List<ProductListDTO> getAllProductListDTO(@Param("productName")String productName);

    @Query("""
            SELECT new com.NalenWebsite.dto.Product.ProductListDTO
            (
                p.productId,
                p.productName,
                p.productDescription,
                p.price,
                p.imagePath
            )
            FROM Products p
            WHERE p.categoryId=:categoryId
                AND (:productName IS NULL OR p.productName LIKE %:productName%)
            """)
    public List<ProductListDTO> getProductListByCategory(@Param("categoryId") Long categoryId, @Param("productName") String productName);
}
