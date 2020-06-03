package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.CourseServiceImpl;
import com.example.springboottest.serviceimpl.RankServiceImpl;
import com.example.springboottest.serviceimpl.ScoreServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/score")
public class scoreController {
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private ScoreServiceImpl scoreServer;
    @Autowired
    private RankServiceImpl rankServer;
    @RequestMapping("")
    public String scorePage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
    {
        user theUser = userServer.loginUser(userid, userpassword);
        if(theUser==null){
            user fakeUser = new user();
            fakeUser.setUsername("");
            map.addAttribute("isExist", false);
            map.addAttribute("theUser", fakeUser);
        }else{
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", theUser);
        }
        List<course> selectedlist = courseServer.selectedCourseList(theUser.getUserid());
        map.addAttribute("selectedlist", selectedlist);
        List<coursescore> scorelist = scoreServer.getCourseScorebyUserid(userid);
        map.addAttribute("scorelist", scorelist);
        return "scorePage";
    }

    @RequestMapping("/taskinsert")
    @ResponseBody
    public String taskinsert(Integer userid, Integer crspointid, Integer score)
    {
        if(scoreServer.isStudentScored(userid, crspointid)){
            courseServer.insertTaskScore(userid, crspointid, score);
            rankServer.increaseStudentRank(userid);
            return "提交成功，本次测试分数为：" + score;
        }else{
            return "该测试已提交过，不会记入分数";
        }
    }

    @RequestMapping("/examinsert")
    @ResponseBody
    public String insertExamScore(Integer userid, Integer examid, Integer groupid, Integer score)
    {
        if(groupid != 0){
            rankServer.increaseGroupRank(groupid);
        }
        courseServer.insertExamScore(userid, examid, score);
        return "success";
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<coursescore> searchCourseScore(Integer studentid, String content)
    {
        List<coursescore> res = scoreServer.searchCourseScorebyUserid(studentid, content);
        return res;
    }

    @RequestMapping("/studentanswerinsert")
    @ResponseBody
    public String studentAnswerInsert(Integer qid, Integer studentid, String answer)
    {
        scoreServer.insertAnswer(qid, studentid, answer);
        return "success";
    }

    @RequestMapping("/studentanswercorrect")
    @ResponseBody
    public String studentAnswerCorrect(Integer qid, Integer studentid, Integer score)
    {
        scoreServer.updateScore(qid, studentid, score);
        return "success";
    }

    @RequestMapping("/updatechoice")
    @ResponseBody
    public String updateChartChoice(Integer studentid, Integer courseid, Integer choicescore, Integer choicesum)
    {
        scoreServer.updatechoice(studentid, courseid, choicescore, choicesum);
        return "success";
    }

    @RequestMapping("/updatetf")
    @ResponseBody
    public String updateChartTf(Integer studentid, Integer courseid, Integer tfscore, Integer tfsum)
    {
        scoreServer.updatetf(studentid, courseid, tfscore, tfsum);
        return "success";
    }

    @RequestMapping("/updatefillin")
    @ResponseBody
    public String updateChartFillin(Integer studentid, Integer courseid, Integer fillinscore, Integer fillinsum)
    {
        scoreServer.updatefillin(studentid, courseid, fillinscore, fillinsum);
        return "success";
    }

    @RequestMapping("/updatesq")
    @ResponseBody
    public String updateChartSq(Integer studentid, Integer courseid, Integer sqscore, Integer sqsum)
    {
        scoreServer.updatesq(studentid, courseid, sqscore, sqsum);
        return "success";
    }

    @RequestMapping("/crsinsert")
    @ResponseBody
    public String courseScroeInsert(Integer studentid, Integer courseid, Integer score)
    {
        coursescore temp = scoreServer.getCourseScore(studentid, courseid);
        if(temp!=null){
            return "该生成绩已登记，为"+ temp.getScore() +"分";
        }
        scoreServer.courseScroeInsert(studentid, courseid, score);
        return "成绩登记成功";
    }
}
