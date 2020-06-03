package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.CourseServiceImpl;
import com.example.springboottest.serviceimpl.GroupServiceImpl;
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

@Controller
@RequestMapping("/progress")
public class progressController {
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private GroupServiceImpl groupServer;
    @Autowired
    private ScoreServiceImpl scoreServer;
    @RequestMapping("")
    public String chapterHomePage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        return "progressHome";
    }
    @RequestMapping("chapterprogress")
    @ResponseBody
    public List<crspointscore> getChapterProgress(ModelMap map,Integer studentid, Integer courseid){
        List<crspointscore> res = scoreServer.getTestScorebyUserid(courseid, studentid);
        return res;
    }
    @RequestMapping("examprogress")
    @ResponseBody
    public List<examscore> getExamProgress(ModelMap map, Integer studentid, Integer courseid){
        List<examscore> res = scoreServer.getExamScorebyUserid(courseid, studentid);
        return res;
    }

    @RequestMapping("chart")
    @ResponseBody
    public studentchart getChart(ModelMap map, Integer studentid, Integer courseid){
        studentchart res = courseServer.getStudentchart(studentid, courseid);
        return res;
    }
}
