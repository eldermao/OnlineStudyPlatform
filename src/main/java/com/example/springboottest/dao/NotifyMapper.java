package com.example.springboottest.dao;

import com.example.springboottest.module.group;
import com.example.springboottest.module.notify;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Component
public interface NotifyMapper {
    @Select("SELECT *\n" +
            "FROM notify NATURAL JOIN p_user\n" +
            "ORDER BY TIME DESC\n")
    List<notify> getNotify();

    @Select("SELECT *\n" +
            "FROM notify NATURAL JOIN p_user\n" +
            "ORDER BY TIME DESC\n" +
            "LIMIT 5")
    List<notify> getNotify5();

    @Select("SELECT *\n" +
            "FROM notify NATURAL JOIN p_user\n" +
            "where notifyid = #{notifyid}\n")
    notify getNotifybyNotifyid(Integer notifyid);

    @Insert("insert into notify values(#{notifyid}, #{title}, #{pic}, #{content}, #{time}, #{userid})")
    void insertNotify(Integer userid, String title, String content, String pic, Integer notifyid, String time );
}
