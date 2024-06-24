package com.NalenWebsite.dto.Category;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpsertCategoryDTO {
    private Long id;

    @NotBlank(message = "Nama category tidak boleh kosong")
    private String categoryName;

    private String categoryDescription;
}
