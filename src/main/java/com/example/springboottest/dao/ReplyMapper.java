package com.example.springboottest.dao;

import com.example.springboottest.module.crspoint;
import com.example.springboottest.module.reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReplyMapper {
    @Select("select * from reply natural join p_user where commentsid = #{commentsid}")
    List<reply> getReplyList(Integer commentsid);

    @Insert("insert into reply values(#{replyid}, #{commentsid}, #{userid}, #{content})")
    void insertReply(Integer replyid, Integer commentsid, Integer userid, String content);

    @Select("select count(*) from reply")
    int getSumofReply();
}
