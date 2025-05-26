package com.example.rssFeed.service;

import com.example.rssFeed.domain.dto.NewsDto;
import com.example.rssFeed.domain.dto.RssDto;
import com.example.rssFeed.domain.entity.NewsEntity;
import com.example.rssFeed.integration.NasaClientService;
import com.example.rssFeed.repository.NewsRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import static com.example.rssFeed.domain.assembler.NewsAssembler.toEntity;
import static jakarta.xml.bind.JAXBContext.newInstance;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewsService {

    private final NasaClientService client;

    private final NewsRepository repository;

    public List<NewsDto> findNews() {
        try {
            String content = client.getNews();
            JAXBContext jaxbContext = newInstance(RssDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            RssDto rssDto = (RssDto) unmarshaller.unmarshal(new StringReader(content));

            List<NewsDto> newsDto = rssDto.getChannel().getItem();

            List<NewsEntity> newsEntities = new ArrayList<>();
            newsDto.forEach(news -> {
                news.setText(extractParagraphs(news.getContent()));
                newsEntities.add(toEntity(news));
            });

            repository.insert(newsEntities);

            return newsDto;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

    private String extractParagraphs(String content) {
        Document document = Jsoup.parse(content);
        Elements elements = document.getElementsByTag("p");

        return elements.text();
    }
}
