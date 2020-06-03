package com.example.springboottest.dao;

import com.example.springboottest.module.grouprank;
import com.example.springboottest.module.reply;
import com.example.springboottest.module.studentrank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RankMapper {
    @Select("SELECT studentid, username AS studentname, score, profile, rank() over(order by score desc) AS `rank`\n" +
            "FROM studentrank S JOIN p_user U\n" +
            "WHERE S.studentid = U.userid\n" +
            "ORDER BY score DESC\n" +
            "LIMIT 10")
    List<studentrank> getStudentRank();

    @Insert("insert into studentrank values(#{studentid}, 0)")
    void insertStudentRank(Integer studentid);

    @Update("update studentrank set score = score + 1 where studentid = #{studentid}")
    void increaseStudentRank(Integer studentid);

    @Select("SELECT *\n" +
            "FROM (SELECT studentid, username AS studentname, score, PROFILE, rank() over(order by score desc) AS `rank`\n" +
            "FROM studentrank S JOIN p_user U\n" +
            "WHERE S.studentid = U.userid\n" +
            "ORDER BY score DESC\n" +
            ") S\n" +
            "WHERE studentid = #{studentid}")
    studentrank getStudentRankbyStudentid(Integer studentid);

    @Select("SELECT groupid, groupname, score\n" +
            "FROM grouprank S natural JOIN `group` G\n" +
            "ORDER BY score DESC\n" +
            "LIMIT 10")
    List<grouprank> getGroupRank();

    @Insert("insert into grouprank values(#{groupid}, 0)")
    void insertGroupRank(Integer groupid);

    @Update("update grouprank set score = score + 1 where groupid = #{groupid}")
    void increaseGroupRank(Integer groupid);
}
