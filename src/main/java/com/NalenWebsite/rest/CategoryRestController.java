package com.NalenWebsite.rest;

import com.NalenWebsite.dto.Category.UpsertCategoryDTO;
import com.NalenWebsite.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Object> getAllCategories(@RequestParam(required = false) String categoryName) {
        var data = categoryService.categoryList(categoryName);
        return ResponseEntity.status(200).body(data);
    }

//    @PostMapping
//    public ResponseEntity<Object> addCategory(@Valid @RequestBody UpsertCategoryDTO dto, BindingResult bindingResult) {
//        var response = categoryService.upsertCategory(dto);
//        if (bindingResult.hasErrors()) {
//            return ResponseEntity.status(400).body(bindingResult.getFieldError().getDefaultMessage());
//        }
//        return ResponseEntity.status(200).body(response);
//    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(200).body("Category has been deleted");
    }
}
