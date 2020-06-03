package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.GroupMapper;
import com.example.springboottest.dao.NewsMapper;
import com.example.springboottest.module.news;
import com.example.springboottest.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public List<news> getNews(Integer receiverid) {
        try{
            return newsMapper.getNews(receiverid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public news getNewsbyNewsid(Integer newsid) {
        try{
            return newsMapper.getNewsbyNewsid(newsid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertNews(Integer newsid, Integer senderid, Integer receiverid, String title, String content, String time) {
        try{
            newsMapper.insertNews(newsid, senderid, receiverid, title, content, time);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void readNews(Integer newsid) {
        try{
            newsMapper.readNews(newsid);
        }catch(Exception e){
            throw e;
        }
    }
}
