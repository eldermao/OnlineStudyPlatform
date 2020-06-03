package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.CourseServiceImpl;
import com.example.springboottest.serviceimpl.NotifyServiceImpl;
import com.example.springboottest.serviceimpl.RankServiceImpl;
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
public class helloController {
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private NotifyServiceImpl notifyServer;
    @Autowired
    private RankServiceImpl rankServer;
    @RequestMapping("")
    public String hello(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException {
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
        List<notify> notifyList = notifyServer.getNotify5();
        map.addAttribute("notifyList", notifyList);
        List<studentrank> studentrankList = rankServer.getStudentRank();
        map.addAttribute("studentrankList", studentrankList);
        List<grouprank> grouprankList = rankServer.getGroupRank();
        map.addAttribute("grouprankList", grouprankList);
        List<recommendcourse> recommendCourseList = courseServer.getRecommendCourseList();
        map.addAttribute("recommendCourseList", recommendCourseList);

        return "home";
    }

    @RequestMapping("getpersonrank")
    @ResponseBody
    public List<studentrank> getPersonrank(){
        List<studentrank> res = rankServer.getStudentRank();
        return res;
    }

    @RequestMapping("getgrouprank")
    @ResponseBody
    public List<grouprank> getGrouprank(){
        List<grouprank> res = rankServer.getGroupRank();
        return res;
    }
}
