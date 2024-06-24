package com.NalenWebsite.repository;

import com.NalenWebsite.dto.Category.CategoryListDTO;
import com.NalenWebsite.entity.Categories;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Categories, Long> {
    @Query("""
            SELECT new com.NalenWebsite.dto.Category.CategoryListDTO
            (
                cat.categoryId,
                cat.categoryName,
                cat.categoryDescription
            )
            FROM Categories as cat
            WHERE (:categoryName IS NULL OR cat.categoryName LIKE %:categoryName%)
            """)
    public List<CategoryListDTO> getCategoryList(@Param("categoryName") String categoryName);

    public boolean existsByCategoryName(@Param("categoryName") String categoryName);
}
