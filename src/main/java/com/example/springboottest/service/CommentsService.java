package com.example.springboottest.service;

import com.example.springboottest.module.chapter;
import com.example.springboottest.module.comments;
import com.example.springboottest.module.crspoint;
import com.example.springboottest.module.reply;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CommentsService {
    Map<comments, List<reply>> getCommentslist(Integer crspointid);
    int getSumOfComments();
    void addComment(Integer crspointid, Integer userid, String content);
    int getSumOfReply();
    void addReply(Integer commentsid, Integer userid, String content);
}
