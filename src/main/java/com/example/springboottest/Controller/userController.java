package com.example.springboottest.Controller;

import com.example.springboottest.module.group;
import com.example.springboottest.module.news;
import com.example.springboottest.module.studentrank;
import com.example.springboottest.module.user;
import com.example.springboottest.service.GroupService;
import com.example.springboottest.serviceimpl.GroupServiceImpl;
import com.example.springboottest.serviceimpl.NewsServiceImpl;
import com.example.springboottest.serviceimpl.RankServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private GroupServiceImpl groupServer;
    @Autowired
    private RankServiceImpl rankServer;
    @Autowired
    private NewsServiceImpl newsServer;
    @RequestMapping("")
    public String userpage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword, HttpServletResponse response, HttpServletRequest request){
        if(!userid.equals("")&&!userpassword.equals("")){
            user res = userServer.findUserById(userid);
            map.addAttribute("isExist", true);
            map.addAttribute("theUser", res);
            List<group> grouplist = groupServer.searchGroupByStudentid(userid);
            map.addAttribute("grouplist", grouplist);
            List<group> applygrouplist = groupServer.searchApplyGroupByStudentid(userid);
            map.addAttribute("applygrouplist", applygrouplist);
            List<group> leadgrouplist = groupServer.searchGroupByLeaderid(userid);
            map.addAttribute("leadgrouplist", leadgrouplist);
            studentrank Studentrank = rankServer.getStudentRankbyStudentid(userid);
            map.addAttribute("Studentrank", Studentrank);
            List<studentrank> studentranklist = rankServer.getStudentRank();
            map.addAttribute("studentranklist", studentranklist);
            List<news> newslist = newsServer.getNews(userid);
            map.addAttribute("newslist", newslist);
            return "userPage";
        }
        return "loginUser";
    }
    @RequestMapping("/getuserlist")
    public String getUserList(ModelMap map)
    {
        List<user> res = userServer.getUserList();
        map.addAttribute("userlist", res);
        return "userinfo";
    }
    @RequestMapping("/find")
    public String findUser(ModelMap map, user theUser)
    {
        List<user> res = userServer.findUser(theUser.getUsername());
        if(res.size()==0) {
            map.addAttribute("errorlog", "无此用户");
            return "failed";
        }
        map.addAttribute("userlist", res);
        return "userinfo";
    }
    @RequestMapping("/insert")
    @ResponseBody
    public String insertUser(ModelMap map, user theUser)
    {
        Random r = new Random();
        Integer id = r.nextInt(1000000);
        while(userServer.findUserById(id)!=null){
            id = r.nextInt(1000000);
        }
        theUser.setUserid(id);
        userServer.insertUser(theUser);
        rankServer.insertStudentRank(id);
        String res = theUser.getUserid().toString();
        return res;
    }
    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(ModelMap map, user theUser)
    {
        userServer.updateUser(theUser);
        return "更新成功";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String loginUser(HttpServletResponse response, HttpServletRequest request, ModelMap map, Integer userid, String password)
    {
        user res = userServer.findUserById(userid);
        if(res==null) {
            return "无此用户";
        }
        if(!password.equals(res.getUserpassword())){
            return "密码错误";
        }
        addCookie(userid, password, response, request);
        return "登录成功";
    }
    public static void addCookie(Integer userId,String password, HttpServletResponse response, HttpServletRequest request){
        //创建cookie
        Cookie idCookie = new Cookie("userid", userId.toString());
        Cookie pswdCookie = new Cookie("userpassword", password);
        idCookie.setPath(request.getContextPath()+"/");//设置cookie路径
        pswdCookie.setPath(request.getContextPath()+"/");
        //设置cookie保存的时间 单位：秒
        idCookie.setMaxAge(7*24*60*60);
        pswdCookie.setMaxAge(7*24*60*60);
        //将cookie添加到响应
        response.addCookie(idCookie);
        response.addCookie(pswdCookie);
    }
    @RequestMapping("/loginuser")
    public String loginUser()
    {
        return "loginUser";
    }
    @RequestMapping("/insertuser")
    public String insertUser()
    {
        return "insertUser";
    }
    @RequestMapping("/searchuser")
    public String searchUser()
    {
        return "searchUser";
    }

    @RequestMapping("profile")
    @ResponseBody
    public String changeProfile(Integer userid, MultipartFile imgfile)
    {
        String originalFilename = imgfile.getOriginalFilename();
        //获取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存路径
        //springboot 默认情况下只能加载 resource文件夹下静态资源文件
        String headpath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\profile\\";
        //生成保存文件
        String Filename = userid + substring;
        File uploadFile = new File(headpath+"user_" + Filename);
        System.out.println(uploadFile);
        //将上传文件保存到路径
        try {
            imgfile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        userServer.updateProfile(userid, Filename);
        return "success";
    }

    @RequestMapping("/passwordupdate")
    @ResponseBody
    public String updatePassword(Integer userid, String password, String newpassword)
    {
        user res = userServer.findUserById(userid);
        if(res.getUserpassword().equals(password)){
            userServer.updatePassword(userid, newpassword);
            return "修改成功";
        }
        return "原密码错误";
    }
}