package com.example.rssFeed.domain.assembler;

import com.example.rssFeed.domain.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryAssembler {

    public static List<CategoryEntity> toEntity(List<String> categoriesDto) {
        if (categoriesDto == null || categoriesDto.isEmpty()) {
            return new ArrayList<>();
        }

        return categoriesDto.stream()
                .map(CategoryEntity::new)
                .toList();
    }
}
