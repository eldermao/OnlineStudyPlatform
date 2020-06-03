package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.*;
import com.example.springboottest.module.*;
import com.example.springboottest.service.CourseService;
import com.example.springboottest.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CourseServiceImpl  implements CourseService{
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ChapterMapper chapterMapper;
    @Autowired
    private CrspointMapper crspointMapper;
    @Autowired
    private s_cMapper S_cMapper;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private ChoicequestionMapper choicequestionMapper;
    @Autowired
    private FillinquestionMapper fillinquestionMapper;
    @Autowired
    private TfquestionMapper tfquestionMapper;
    @Autowired
    private ScoreMapper scoreMapper;
    @Autowired
    private StudentchartMapper studentchartMapper;
    @Override
    public List<course> getCourseList() {
        try{
            return courseMapper.getCourseList();
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<course> selectedCourseList(Integer studentid) {
        try{
            return courseMapper.selectedCourseList(studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dropCourse(Integer courseid, Integer studentid) {
        try{
            courseMapper.dropCourse(courseid, studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltS_c(Integer courseid, Integer studentid) {
        try{
            S_cMapper.dltS_c(courseid, studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public Map<chapter, List<crspoint>> chapterCrspoint(Integer courseid) {
        try{
            List<chapter> chapterlist = chapterMapper.searchChapter(courseid);
            Map<chapter, List<crspoint>> res = new LinkedHashMap();
            for(chapter c:chapterlist){
                res.put(c, crspointMapper.searchCrspoint(c.getChapterid()));
            }
            return res;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public chapter searchChapterByChapterid(Integer chapterid) {
        try{
            return chapterMapper.searchChapterByChapterid(chapterid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertChapter(Integer chapterid, String chaptername, Integer courseid) {
        try{
            chapterMapper.insertChapter(chapterid, chaptername, courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void updateCrspoint(Integer crspointid, String crspointname) {
        try{
            crspointMapper.updateCrspoint(crspointid, crspointname);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltChapter(Integer chapterid) {
        try{
            chapterMapper.dltChapter(chapterid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void createCourse(Integer courseid, String coursename, Integer teacherid, String coursepic, Integer max) {
        try{
            courseMapper.createCourse(courseid, coursename, teacherid, coursepic, max);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public course searchCourseByCourseid(Integer courseid) {
        try{
            return courseMapper.searchCourseByCourseid(courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void chooseCourse(Integer courseid, Integer studentid) {
        try{
            courseMapper.chooseCourse(courseid, studentid);
        }catch(Exception e){
            throw e;
        }
    }
    @Override
    public List<choicequestion> getChoicequestionInTask(Integer crspointid) {
        try{
            return choicequestionMapper.getChoicequestionInTask(crspointid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertChoicequestionInTask(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer taskid, Integer score) {
        try{
            choicequestionMapper.insertChoicequestionInTask(qid, qname, c1, c2, c3, c4, answer, taskid, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public choicequestion searchChoicequestionInTask(Integer qid) {
        try{
            return choicequestionMapper.searchChoicequestionInTask(qid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void editChoicequestionInTask(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer score) {
        try{
            choicequestionMapper.editChoicequestionInTask(qid, qname, c1, c2, c3, c4, answer, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltChoicequestionInTask(Integer qid) {
        try{
            choicequestionMapper.dltChoicequestionInTask(qid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<fillinquestion> getFillinquestionInTask(Integer crspointid) {
        try{
            return fillinquestionMapper.getFillinquestionInTask(crspointid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertFillinquestionInTask(Integer qid, String qname, String answer, Integer taskid, Integer score) {
        try{
            fillinquestionMapper.insertFillinquestionInTask(qid, qname, answer, taskid, score);
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
    public fillinquestion searchFillinquestionInTask(Integer qid) {
        try{
            fillinquestion res = fillinquestionMapper.searchFillinquestionInTask(qid);
            return res;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void editFillinquestion(Integer qid, String qname, String answer, Integer score) {
        try{
            fillinquestionMapper.editFillinquestion(qid, qname, answer, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltFillinquestion(Integer qid) {
        try{
            fillinquestionMapper.dltFillinquestion(qid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<tfquestion> getTfquestionInTask(Integer crspointid) {
        try{
            List<tfquestion> res = tfquestionMapper.getTfquestionInTask(crspointid);
            return res;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertTfquestionInTask(Integer qid, String qname, String answer, Integer taskid, Integer score) {
        try{
            tfquestionMapper.insertTfquestionInTask(qid, qname, answer, taskid, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public tfquestion searchTfquestionInTask(Integer qid) {
        try{
            tfquestion res = tfquestionMapper.searchTfquestionInTask(qid);
            return res;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void editTfquestionInTask(Integer qid, String qname, String answer, Integer score) {
        try{
            tfquestionMapper.editTfquestionInTask(qid, qname, answer, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dltTfquestionInTask(Integer qid) {
        try{
            tfquestionMapper.dltTfquestionInTask(qid);
        }catch(Exception e){
            throw e;
        }
    }


    @Override
    public void insertTaskScore(Integer userid, Integer crspointid, Integer score) {
        try{
            scoreMapper.insertScore(userid, 0, 0, 0,0, crspointid, score);
        }catch(Exception e){
            throw e;
        }
    }
    @Override
    public void insertExamScore(Integer userid, Integer examid, Integer score) {
        try{
            scoreMapper.insertScore(userid, 1, 0, 0, examid, 0, score);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<recommendcourse> getRecommendCourseList() {
        try{
            return courseMapper.getRecommendCourseList();
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<course> searchCourseList(String content) {
        try{
            return courseMapper.searchCourseList(content);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<course> getCourseListbyTeacherid(Integer teacherid) {
        try{
            return courseMapper.getCourseListbyTeacherid(teacherid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void insertCrspoint(Integer crspointid, String crspointname, Integer chapterid) {
        try{
            crspointMapper.insertCrspoint(crspointid, crspointname, chapterid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public studentchart getStudentchart(Integer studentid, Integer courseid) {
        try{
            return studentchartMapper.getStudentchart(studentid, courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public course getCoursebyCrspointid(Integer crspointid) {
        try{
            return crspointMapper.getCoursebyCrspointid(crspointid);
        }catch(Exception e){
            throw e;
        }
    }
}
