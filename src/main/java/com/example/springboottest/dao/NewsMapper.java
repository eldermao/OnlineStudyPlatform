package com.example.springboottest.dao;

import com.example.springboottest.module.news;
import com.example.springboottest.module.notify;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsMapper {
    @Select("SELECT newsid, senderid, sendername, receiverid, username AS receivername, title, content, `time`, `read`\n" +
            "FROM (SELECT newsid, senderid, username AS sendername, receiverid, title, content, `time`, `read`\n" +
            "FROM (SELECT * \n" +
            "from news\n" +
            "where receiverid = #{receiverid}) S, p_user\n" +
            "WHERE S.senderid = p_user.userid) S, p_user\n" +
            "where S.receiverid = p_user.userid order by time desc")
    List<news> getNews(Integer receiverid);

    @Select("SELECT newsid, senderid, sendername, receiverid, username AS receivername, title, content, `time`, `read`\n" +
            "FROM (SELECT newsid, senderid, username AS sendername, receiverid, title, content, `time`, `read`\n" +
            "FROM (SELECT * \n" +
            "from news\n" +
            "where newsid = #{newsid}) S, p_user\n" +
            "WHERE S.senderid = p_user.userid) S, p_user\n" +
            "where S.receiverid = p_user.userid order by time desc")
    news getNewsbyNewsid(Integer newsid);

    @Insert("insert into news values(#{newsid}, #{senderid}, #{receiverid}, #{title}, #{content}, #{time}, 0)")
    void insertNews(Integer newsid, Integer senderid, Integer receiverid, String title, String content, String time);

    @Update("update news set `read` = 1 where newsid = #{newsid}")
    void readNews(Integer newsid);
}
