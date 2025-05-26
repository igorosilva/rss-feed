package com.example.rssFeed.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "News")
public class NewsEntity {

    @MongoId
    private String id;

    private String nmTitle;
    private LocalDateTime dtPublication;
    private List<CategoryEntity> categoriesList;
    private String dsNews;
    private String dsInfo;
}
