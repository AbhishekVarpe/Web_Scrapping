package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Resp;
import com.example.demo.service.ScraperService;
@RestController
@CrossOrigin(origins = "*")
public class ScrapeController {

    @Autowired
    private ScraperService scraperService;

    @GetMapping("/api/scrape")
    public Resp scrape(@RequestParam String url) throws IOException {
        return scraperService.webScrape(url);
    }
	

}
