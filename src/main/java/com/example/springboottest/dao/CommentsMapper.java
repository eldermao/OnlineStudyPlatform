package com.example.springboottest.dao;

import com.example.springboottest.module.comments;
import com.example.springboottest.module.course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentsMapper {
    @Select("select * from comments natural join p_user where crspointid = #{crspointid} order by commentsid")
    List<comments> getCommentsList(Integer crspointid);

    @Insert("insert into comments values(#{commentsid}, #{crspointid}, #{userid}, #{content})")
    void insertComment(Integer commentsid, Integer crspointid, Integer userid, String content);

    @Select("select count(*) from comments")
    int getSumofComments();
}
