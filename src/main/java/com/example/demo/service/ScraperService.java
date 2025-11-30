package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import com.example.demo.model.Resp;

@Service
public class ScraperService {

    public Resp webScrape(String url) throws IOException {
        // Connect to the website using Jsoup
    	Document doc = Jsoup.connect(url)
//    	        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
//    	        .timeout(10000)
//    	        .referrer("https://www.google.com/")
    	        .get();


        // Lists to store scraped data
        List<String> images = new ArrayList<>();
        List<String> videos = new ArrayList<>();
        List<String> links = new ArrayList<>();

        // Scrape image URLs
        for (Element img : doc.select("img")) {
            String src = img.absUrl("src");
            if (!src.isEmpty()) {
                images.add(src);
            }
        }

        // Scrape video URLs
        for (Element video : doc.select("video")) {
            String src = video.absUrl("src");
            if (!src.isEmpty()) {
                videos.add(src);
            }
        }

        // Scrape anchor links
        for (Element link : doc.select("a[href]")) {
            String href = link.absUrl("href");
            if (!href.isEmpty()) {
                links.add(href);
            }
        }

        // Prepare response object
        Resp response = new Resp();
        response.setImages(images);
        response.setVideos(videos);
        response.setLinks(links);

        return response;
    }
}
