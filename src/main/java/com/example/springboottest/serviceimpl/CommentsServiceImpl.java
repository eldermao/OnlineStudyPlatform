package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.CommentsMapper;
import com.example.springboottest.dao.CourseMapper;
import com.example.springboottest.dao.ReplyMapper;
import com.example.springboottest.module.chapter;
import com.example.springboottest.module.comments;
import com.example.springboottest.module.crspoint;
import com.example.springboottest.module.reply;
import com.example.springboottest.service.CommentsService;
import com.example.springboottest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public Map<comments, List<reply>> getCommentslist(Integer crspointid) {
        try{
            List<comments> commentslist = commentsMapper.getCommentsList(crspointid);
            Map<comments, List<reply>> res = new LinkedHashMap();
            for(comments c:commentslist){
                res.put(c, replyMapper.getReplyList(c.getCommentsid()));
            }
            return res;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public int getSumOfComments() {
        try{
            return commentsMapper.getSumofComments();
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void addComment(Integer crspointid, Integer userid, String content) {
        try{
            int commentid = commentsMapper.getSumofComments();
            commentsMapper.insertComment(commentid+1, crspointid, userid, content);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public int getSumOfReply() {
        try{
            return replyMapper.getSumofReply();
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void addReply(Integer commentsid, Integer userid, String content) {
        try{
            int replyid = replyMapper.getSumofReply();
            replyMapper.insertReply(replyid+1, commentsid, userid, content);
        }catch(Exception e){
            throw e;
        }
    }
}
