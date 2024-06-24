package com.NalenWebsite.dto.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CategoryListDTO {
    private Long id;
    private String categoryName;
    private String categoryDescription;
}
