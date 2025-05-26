package com.example.rssFeed.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.xml.bind.annotation.XmlAccessType.FIELD;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "item")
@XmlAccessorType(FIELD)
public class NewsDto {
    private String title;
    private String pubDate;
    private List<String> category;
    private String description;

    @JsonIgnore
    @XmlElement(name = "encoded", namespace = "http://purl.org/rss/1.0/modules/content/")
    private String content;

    private String text;
}
