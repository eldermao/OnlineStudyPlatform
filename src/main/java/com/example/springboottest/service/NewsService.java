package com.example.springboottest.service;

import com.example.springboottest.module.news;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {
    List<news> getNews(Integer receiverid);
    news getNewsbyNewsid(Integer newsid);
    void insertNews(Integer newsid, Integer senderid, Integer receiverid, String title, String content, String time);
    void readNews(Integer newsid);
}
