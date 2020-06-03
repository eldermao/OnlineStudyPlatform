package com.example.springboottest.Controller;

import com.example.springboottest.module.course;
import com.example.springboottest.module.s_c;
import com.example.springboottest.module.user;
import com.example.springboottest.serviceimpl.CourseServiceImpl;
import com.example.springboottest.serviceimpl.ScoreServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
import com.example.springboottest.serviceimpl.s_cServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/course")
public class courseController {
    @Autowired
    private CourseServiceImpl courseServer;
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private ScoreServiceImpl scoreServer;
    @Autowired
    private s_cServiceImpl S_cServiceImpl;
    @RequestMapping("")
    public String courseHomePage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        List<course> courselist = courseServer.getCourseList();
        map.addAttribute("courselist", courselist);
        map.addAttribute("selectedlist", selectedlist);
        return "courseHome";
    }

    @RequestMapping("manage")
    public String manageCoursePage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        List<course> courseList = courseServer.getCourseListbyTeacherid(theUser.getUserid());
        map.addAttribute("courseList", courseList);
        return "courseManage";
    }

    @RequestMapping("studentmanage")
    @ResponseBody
    public List<user> getUserListbyCourseid(ModelMap map, Integer courseid){

        List<user> res = userServer.getUserListbyCourseid(courseid);
        return res;
    }

    @RequestMapping("studentpop")
    @ResponseBody
    public String studentPop(Integer courseid, Integer studentid){

        courseServer.dltS_c(courseid, studentid);
        return "删除成功";
    }

    @RequestMapping("search")
    @ResponseBody
    public List<course> searchCourse(ModelMap map, String content){

        List<course> res = courseServer.searchCourseList(content);
        return res;
    }

    @RequestMapping("create")
    public String insertCourse(ModelMap map, String coursename, Integer teacherid, Integer max, MultipartFile imgfile)
    {
        Random r = new Random();
        Integer courseid = r.nextInt(1000000);
        while(courseServer.searchCourseByCourseid(courseid)!=null){
            courseid = r.nextInt(1000000);
        }
        //获取上传文件名,包含后缀
        String originalFilename = imgfile.getOriginalFilename();
        //获取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存路径
        //springboot 默认情况下只能加载 resource文件夹下静态资源文件
        String headpath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\coursePic\\";
        //生成保存文件
        String Filename = "crs_" + courseid + substring;
        File uploadFile = new File(headpath+Filename);
        System.out.println(uploadFile);
        //将上传文件保存到路径
        try {
            imgfile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        courseServer.createCourse(courseid, coursename, teacherid, Filename, max);
        return "success";
    }

    @RequestMapping("/choose")
    @ResponseBody
    public String chooseCourse(ModelMap map, Integer courseid, Integer studentid){
        s_c temp = S_cServiceImpl.findS_c(courseid, studentid);
        if(temp!=null){
            return "已选该课";
        }
        scoreServer.insertChart(studentid, courseid);
        courseServer.chooseCourse(courseid, studentid);
        return "选课成功";
    }

    @RequestMapping("/drop")
    @ResponseBody
    public String dropCourse(ModelMap map, Integer courseid, Integer studentid){
        courseServer.dropCourse(courseid, studentid);
        return "退课成功";
    }
}
