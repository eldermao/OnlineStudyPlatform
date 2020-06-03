package com.example.springboottest.dao;

import com.example.springboottest.module.sqstudentanswer;
import com.example.springboottest.module.subjectivequestion;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SQstudentanswerMapper {
    @Select("SELECT S.qid, studentid, answer, score, iscorrected, qname, maxscore, username AS studentname\n" +
            "FROM (\n" +
            "SELECT S.qid, studentid, answer, S.score, iscorrected, qname, Q.score AS maxscore\n" +
            "FROM (\n" +
            "SELECT *\n" +
            "FROM sqstudentanswer\n" +
            "WHERE qid IN(\n" +
            "\tSELECT qid\n" +
            "FROM subjectivequestion\n" +
            "WHERE examid = #{examid}\n" +
            ")\n" +
            ") S , subjectivequestion Q\n" +
            "WHERE S.qid = Q.qid\n" +
            ") S, p_user\n" +
            "WHERE p_user.userid = S.studentid")
    List<sqstudentanswer> getSQstudentanswer(Integer examid);

    @Select("select * from sqstudentanswer where qid = #{qid}")
    sqstudentanswer getSQstudentanswerbyId(Integer qid);

    @Update("update sqstudentanswer set score = #{score}, iscorrected = 1, score = #{score} where qid = #{qid} and studentid = #{studentid}")
    void updateScore(Integer qid, Integer studentid, Integer score);
}
