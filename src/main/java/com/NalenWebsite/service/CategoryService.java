package com.NalenWebsite.service;

import com.NalenWebsite.dto.Category.CategoryListDTO;
import com.NalenWebsite.dto.Category.UpsertCategoryDTO;
import com.NalenWebsite.entity.Categories;
import com.NalenWebsite.repository.CategoryRepository;
import com.NalenWebsite.utility.Exception.CategoryNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryListDTO> categoryList(String categoryName){
        var data = categoryRepository.getCategoryList(categoryName);
        return data;
    }

    public UpsertCategoryDTO upsertCategory(UpsertCategoryDTO categoryDTO){
        if (categoryRepository.existsByCategoryName(categoryDTO.getCategoryName())){
            throw new CategoryNameException("Category name already exists");
        }

        var categories = new Categories();
        categories.setCategoryId(categoryDTO.getId());
        categories.setCategoryName(categoryDTO.getCategoryName());
        categories.setCategoryDescription(categoryDTO.getCategoryDescription());
        var responseEntity = categoryRepository.save(categories);
        var responseDTO = new UpsertCategoryDTO(
                responseEntity.getCategoryId(),
                responseEntity.getCategoryName(),
                responseEntity.getCategoryDescription()
        );
        return responseDTO;
    }

    public void deleteCategory(Long categoryId){
        var category = categoryRepository.findById(categoryId).get();
        categoryRepository.delete(category);
    }
}
