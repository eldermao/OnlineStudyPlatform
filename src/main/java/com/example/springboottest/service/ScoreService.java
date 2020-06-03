package com.example.springboottest.service;

import com.example.springboottest.module.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScoreService {

    void updateScore(Integer qid, Integer studentid, Integer score);

    List<crspointscore> getTestScorebyUserid(Integer courseid, Integer studentid);

    List<examscore> getExamScorebyUserid(Integer courseid, Integer studentid);

    List<coursescore> getCourseScorebyUserid(Integer studentid);

    List<coursescore> searchCourseScorebyUserid(Integer studentid, String content);

    void insertAnswer(Integer qid, Integer studentid, String answer);

    sqstudentanswer getSQstudentanswerbyId(Integer qid);

    boolean isStudentScored(Integer studentid, Integer crspointid);
    boolean isStudentExamed(Integer studentid, Integer examid);

    void insertChart(Integer studentid, Integer courseid);
    void updatechoice(Integer studentid, Integer courseid, Integer choicescore, Integer choicesum);
    void updatetf(Integer studentid, Integer courseid, Integer tfscore, Integer tfsum);
    void updatefillin(Integer studentid, Integer courseid, Integer fillinscore, Integer fillinsum);
    void updatesq(Integer studentid, Integer courseid, Integer sqscore, Integer sqsum);

    void courseScroeInsert(Integer studentid, Integer courseid, Integer score);
    coursescore getCourseScore(Integer studentid, Integer courseid);
}
