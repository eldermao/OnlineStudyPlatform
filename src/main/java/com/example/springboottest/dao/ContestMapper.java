package com.example.springboottest.dao;

import com.example.springboottest.module.contest;
import com.example.springboottest.module.course;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContestMapper {
    @Select("SELECT contestid, S.examid, examname, g1id, g1name, g2id, g2name, S.starttime, S.endtime\n" +
            "FROM (SELECT contestid, examid, g1id, g1name, g2id, groupname AS g2name, starttime, endtime\n" +
            "FROM (SELECT contestid, examid, g1id, groupname AS g1name, g2id, starttime, endtime\n" +
            "FROM (SELECT *\n" +
            "FROM contest\n" +
            "WHERE g1id IN (\n" +
            "SELECT groupid\n" +
            "FROM student_group\n" +
            "WHERE studentid = #{studentid}\n" +
            ") OR g2id in (\n" +
            "SELECT groupid\n" +
            "FROM student_group\n" +
            "WHERE studentid = #{studentid}\n" +
            ")) S, `group`\n" +
            "WHERE S.g1id = `group`.groupid ) S, `group`\n" +
            "WHERE S.g2id = `group`.groupid) S, exam\n" +
            "WHERE S.examid = exam.examid")
    List<contest> getContestbyStudentid(Integer studentid);

    @Insert("insert into contest values(#{contestid}, #{examid}, #{g1id}, #{g2id}, #{starttime}, #{endtime})")
    void challengeGroup(Integer contestid, Integer examid, Integer g1id, Integer g2id, Integer starttime, Integer endtime);
}
