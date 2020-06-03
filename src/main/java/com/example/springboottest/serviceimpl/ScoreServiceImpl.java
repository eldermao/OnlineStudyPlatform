package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.GroupMapper;
import com.example.springboottest.dao.SQstudentanswerMapper;
import com.example.springboottest.dao.ScoreMapper;
import com.example.springboottest.dao.StudentchartMapper;
import com.example.springboottest.module.*;
import com.example.springboottest.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private SQstudentanswerMapper sqstudentanswerMapper;
    @Autowired
    private StudentchartMapper studentchartMapper;
    @Override
    public void updateScore(Integer qid, Integer studentid, Integer score) {
        sqstudentanswerMapper.updateScore(qid, studentid, score);
    }

    @Override
    public List<crspointscore> getTestScorebyUserid(Integer courseid, Integer studentid) {
        try {
            List<crspointscore> res = scoreMapper.getTestScorebyUserid(courseid, studentid);
            return  res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public List<examscore> getExamScorebyUserid(Integer courseid, Integer studentid) {
        try {
            List<examscore> res = scoreMapper.getExamScorebyUserid(courseid, studentid);
            return  res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public List<coursescore> getCourseScorebyUserid(Integer studentid) {
        try {
            List<coursescore> res = scoreMapper.getCourseScorebyUserid(studentid);
            return  res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public List<coursescore> searchCourseScorebyUserid(Integer studentid, String content) {
        try {
            List<coursescore> res = scoreMapper.searchCourseScorebyUserid(studentid, content);
            return  res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void insertAnswer(Integer qid, Integer studentid, String answer) {
        try {
            scoreMapper.insertAnswer(qid, studentid, answer);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public sqstudentanswer getSQstudentanswerbyId(Integer qid) {
        try {
            sqstudentanswer res = sqstudentanswerMapper.getSQstudentanswerbyId(qid);
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public boolean isStudentScored(Integer studentid, Integer crspointid) {
        try {
            crspointscore res = scoreMapper.isStudentScored(studentid, crspointid);
            if(res==null){
                return true;
            }else{
                return false;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public boolean isStudentExamed(Integer studentid, Integer examid) {
        try {
            examscore res = scoreMapper.isStudentExamed(studentid, examid);
            if(res==null){
                return true;
            }else{
                return false;
            }
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void insertChart(Integer studentid, Integer courseid) {
        try {
            studentchartMapper.insertChart(studentid, courseid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void updatechoice(Integer studentid, Integer courseid, Integer choicescore, Integer choicesum) {
        try {
            studentchartMapper.updatechoice(studentid, courseid, choicescore, choicesum);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void updatetf(Integer studentid, Integer courseid, Integer tfscore, Integer tfsum) {
        try {
            studentchartMapper.updatetf(studentid, courseid, tfscore, tfsum);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void updatefillin(Integer studentid, Integer courseid, Integer fillinscore, Integer fillinsum) {
        try {
            studentchartMapper.updatefillin(studentid, courseid, fillinscore, fillinsum);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void updatesq(Integer studentid, Integer courseid, Integer sqscore, Integer sqsum) {
        try {
            studentchartMapper.updatesq(studentid, courseid, sqscore, sqsum);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void courseScroeInsert(Integer studentid, Integer courseid, Integer score) {
        try {
            scoreMapper.courseScroeInsert(studentid, courseid, score);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public coursescore getCourseScore(Integer studentid, Integer courseid) {
        try {
            return scoreMapper.getCourseScore(studentid, courseid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
