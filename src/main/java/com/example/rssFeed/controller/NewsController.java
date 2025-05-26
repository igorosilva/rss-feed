package com.example.rssFeed.controller;

import com.example.rssFeed.domain.dto.NewsDto;
import com.example.rssFeed.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService service;

    @PostMapping
    public ResponseEntity<List<NewsDto>> findNews() {

        List<NewsDto> result = service.findNews();

        return ResponseEntity.ok(result);
    }
}
