package com.example.rssFeed.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${nasa-client.url}", name = "nasaClient")
public interface NasaClient {

    @GetMapping
    String getNews();
}
