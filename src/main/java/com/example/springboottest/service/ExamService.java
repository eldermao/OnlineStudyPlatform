package com.example.springboottest.service;

import com.example.springboottest.module.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    List<exam> getExamList(Integer studentid);
    List<choicequestion> getChoicequestionInExam(Integer examid);
    void insertChoicequestionInExam(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer examid, Integer score);
    void editExam(Integer examid, String examname, Integer starttime, Integer endtime);
    exam searchExam(Integer examid);
    void dltExam(Integer examid);
    void insertExam(Integer examid, String examname, Integer starttime, Integer endtime, Integer courseid);
    void insertContest(Integer examid, String examname, Integer courseid);

    List<fillinquestion> getFillinquestionInExam(Integer examid);
    void insertFillinquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score);

    List<tfquestion> getTfquestionInExam(Integer examid);
    void insertTfquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score);

    List<subjectivequestion> getSubjectivequestionInExam(Integer examid);
    void insertSubquestionInExam(Integer qid, String qname, Integer examid, Integer score);
    void editSubquestionInExam(Integer qid, String qname, Integer score);
    void dltSubquestionInExam(Integer qid);

    List<sqstudentanswer> getSQstudentanswer(Integer examid);
    List<exam> getExamListbyCourseid(Integer courseid);

    List<coursecontest> getCoursecontestbyCourseid(Integer courseid);
    List<contest> getContestbyStudentid(Integer studentid);

    void challengeGroup(Integer contestid, Integer examid, Integer g1id, Integer g2id, Integer starttime, Integer endtime);
}
