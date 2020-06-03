package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.*;
import com.example.springboottest.module.*;
import com.example.springboottest.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private CoursecontestMapper coursecontestMapper;
    @Autowired
    private ContestMapper contestMapper;
    @Autowired
    private ChoicequestionMapper choicequestionMapper;
    @Autowired
    private FillinquestionMapper fillinquestionMapper;
    @Autowired
    private TfquestionMapper tfquestionMapper;
    @Autowired
    private SubjectivequestionMapper subjectivequestionMapper;
    @Autowired
    private SQstudentanswerMapper sqstudentanswerMapper;
    @Override
    public List<exam> getExamList(Integer studentid) {
        try{
            return examMapper.ExamList(studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<choicequestion> getChoicequestionInExam(Integer examid) {
        try{
            return choicequestionMapper.getChoicequestionInExam(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertChoicequestionInExam(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer examid, Integer score) {
        try{
            choicequestionMapper.insertChoicequestionInExam(qid, qname, c1, c2, c3, c4, answer, examid, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void editExam(Integer examid, String examname, Integer starttime, Integer endtime) {
        try{
            examMapper.editExam(examid, examname, starttime, endtime);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public exam searchExam(Integer examid) {
        try{
            return examMapper.searchExam(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltExam(Integer examid) {
        try{
            examMapper.dltExam(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertExam(Integer examid, String examname, Integer starttime, Integer endtime, Integer courseid) {
        try{
            examMapper.insertExam(examid, examname, starttime, endtime, courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertContest(Integer examid, String examname, Integer courseid) {
        try{
            examMapper.insertContest(examid, examname, courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<fillinquestion> getFillinquestionInExam(Integer examid) {
        try{
            return fillinquestionMapper.getFillinquestionInExam(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertFillinquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score) {
        try{
            fillinquestionMapper.insertFillinquestionInExam(qid, qname, answer, examid, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<tfquestion> getTfquestionInExam(Integer examid) {
        try{
            return tfquestionMapper.getTfquestionInExam(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertTfquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score) {
        try{
            tfquestionMapper.insertTfquestionInExam(qid, qname, answer, examid, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<subjectivequestion> getSubjectivequestionInExam(Integer examid) {
        try{
            return subjectivequestionMapper.getSubjectivequestionInExam(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertSubquestionInExam(Integer qid, String qname, Integer examid, Integer score) {
        try{
            subjectivequestionMapper.insertSubquestionInExam(qid, qname, examid, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void editSubquestionInExam(Integer qid, String qname, Integer score) {
        try{
            subjectivequestionMapper.editSubquestionInExam(qid, qname, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltSubquestionInExam(Integer qid) {
        try{
            subjectivequestionMapper.dltSubquestionInExam(qid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<sqstudentanswer> getSQstudentanswer(Integer examid) {
        try{
            return sqstudentanswerMapper.getSQstudentanswer(examid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<exam> getExamListbyCourseid(Integer courseid) {
        try{
            return examMapper.getExamListbyCourseid(courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<coursecontest> getCoursecontestbyCourseid(Integer courseid) {
        try{
            return coursecontestMapper.getCoursecontestbyCourseid(courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<contest> getContestbyStudentid(Integer studentid) {
        try{
            return contestMapper.getContestbyStudentid(studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void challengeGroup(Integer contestid, Integer examid, Integer g1id, Integer g2id, Integer starttime, Integer endtime) {
        try{
            contestMapper.challengeGroup(contestid, examid, g1id, g2id, starttime, endtime);
        }catch(Exception e){
            throw e;
        }
    }
}
