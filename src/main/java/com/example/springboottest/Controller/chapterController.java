package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.CourseServiceImpl;
import com.example.springboottest.serviceimpl.ExamServiceImpl;
import com.example.springboottest.serviceimpl.GroupServiceImpl;
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
@RequestMapping("/chapter")
public class chapterController {
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private GroupServiceImpl groupServer;
    @Autowired
    private ExamServiceImpl examServer;
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
        return "selectedCourse";
    }
    @RequestMapping("/point")
    public String coursepoint(ModelMap map, Integer courseid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
    {
        user theUser = userServer.loginUser(userid, userpassword);
        if(theUser==null){
            user fakeUser = new user();
            fakeUser.setUsername("");
            map.addAttribute("isExist", false);
            map.addAttribute("theUser", fakeUser);
            return "home";
        }else{
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", theUser);
        }
        Map<chapter, List<crspoint>> chapterlist = courseServer.chapterCrspoint(courseid);
        map.addAttribute("courseid", courseid);
        map.addAttribute("chapterlist", chapterlist);
        List<group> grouplist = groupServer.searchGroupByCourseid(courseid);
        map.addAttribute("grouplist", grouplist);
        group isgrouped = groupServer.isGrouped(courseid, userid);
        if(isgrouped==null){
            group fakeGroup = new group();
            map.addAttribute("isGrouped", false);
            map.addAttribute("theGroup", fakeGroup);
        }else{
            map.addAttribute("isGrouped", true);
            map.addAttribute("theGroup", isgrouped);
        }
        List<coursecontest> contestlist = examServer.getCoursecontestbyCourseid(courseid);
        map.addAttribute("contestlist", contestlist);
        return "courseChapter";
    }

    @RequestMapping("manage")
    public String chapterManagePage(ModelMap map, Integer courseid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        Map<chapter, List<crspoint>> chapterlist = courseServer.chapterCrspoint(courseid);
        map.addAttribute("courseid", courseid);
        map.addAttribute("chapterlist", chapterlist);
        return "crspointManage";
    }
    @RequestMapping("dlt")
    @ResponseBody
    public String dltChapter(Integer chapterid){

        courseServer.dltChapter(chapterid);
        return "删除成功";
    }
    @RequestMapping("insert")
    @ResponseBody
    public String insertChapter(String chaptername, Integer courseid){
        Random r = new Random();
        Integer id = r.nextInt(1000000);
        while(courseServer.searchChapterByChapterid(id)!=null){
            courseid = r.nextInt(1000000);
        }
        courseServer.insertChapter(id, chaptername, courseid);
        return "添加章节成功";
    }
}
