package com.example.rssFeed.integration;

import com.example.rssFeed.integration.client.NasaClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NasaClientService {

    private final NasaClient client;

    @Retryable(maxAttempts = 3, backoff = @Backoff(delay = 5000))
    public String getNews() {
        var response = client.getNews();
        return response;
    }

    @Recover
    public void getNewsRecover(Exception e) {
        log.error(e.getMessage(), e);
    }
}
