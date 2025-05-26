package com.example.rssFeed.scheduller;

import com.example.rssFeed.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NewsScheduller {

    private final NewsService service;

    @Scheduled(cron = "${nasa-client.cron}")
    private void findNews() {
        log.info("Executando cron para buscar novas notícias");

        service.findNews();

        log.info("Cron executado com sucesso!");
    }
}
