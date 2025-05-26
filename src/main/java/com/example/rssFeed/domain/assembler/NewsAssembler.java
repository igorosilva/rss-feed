package com.example.rssFeed.domain.assembler;

import com.example.rssFeed.domain.dto.NewsDto;
import com.example.rssFeed.domain.entity.NewsEntity;

import static com.example.rssFeed.utils.DateUtils.StringToLocalDateTime;

public class NewsAssembler {

    public static NewsEntity toEntity(NewsDto dto) {
        if (dto == null) {
            return null;
        }

        return NewsEntity.builder()
                .nmTitle(dto.getTitle())
                .dtPublication(StringToLocalDateTime(dto.getPubDate()))
                .categoriesList(CategoryAssembler.toEntity(dto.getCategory()))
                .dsInfo(dto.getText())
                .build();
    }
}
