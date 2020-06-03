package com.example.springboottest.service;

import com.example.springboottest.module.*;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CourseService {
    List<course> getCourseList();
    void createCourse(Integer courseid, String coursename, Integer teacherid, String coursepic, Integer max);
    course searchCourseByCourseid(Integer courseid);
    void chooseCourse(Integer courseid, Integer studentid);
    List<course> selectedCourseList(Integer studentid);
    void dropCourse(Integer courseid, Integer studentid);
    void dltS_c(Integer courseid, Integer studentid);
    Map<chapter, List<crspoint>> chapterCrspoint(Integer courseid);
    chapter searchChapterByChapterid(Integer chapterid);
    void insertChapter(Integer chapterid, String chaptername, Integer courseid);
    void updateCrspoint(Integer crspointid, String crspointname);
    void dltChapter(Integer chapterid);

    List<choicequestion> getChoicequestionInTask(Integer crspointid);
    void insertChoicequestionInTask(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer taskid, Integer score);
    choicequestion searchChoicequestionInTask(Integer qid);
    void editChoicequestionInTask(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer score);
    void dltChoicequestionInTask(Integer qid);

    List<fillinquestion> getFillinquestionInTask(Integer crspointid);
    void insertFillinquestionInTask(Integer qid, String qname, String answer, Integer taskid, Integer score);
    void insertFillinquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score);
    fillinquestion searchFillinquestionInTask(Integer qid);
    void editFillinquestion(Integer qid, String qname, String answer, Integer score);
    void dltFillinquestion(Integer qid);

    List<tfquestion> getTfquestionInTask(Integer crspointid);
    void insertTfquestionInTask(Integer qid, String qname, String answer, Integer taskid, Integer score);
    tfquestion searchTfquestionInTask(Integer qid);
    void editTfquestionInTask(Integer qid, String qname, String answer, Integer score);
    void dltTfquestionInTask(Integer qid);

    void insertTaskScore(Integer userid, Integer crspointid, Integer score);
    void insertExamScore(Integer userid, Integer exam, Integer score);
    List<recommendcourse> getRecommendCourseList();
    List<course> searchCourseList(String content);
    List<course> getCourseListbyTeacherid(Integer teacherid);

    void insertCrspoint(Integer crspointid, String crspointname, Integer chapterid);

    studentchart getStudentchart(Integer studentid, Integer courseid);

    course getCoursebyCrspointid(Integer crspointid);
}
