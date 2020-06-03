package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.NewsServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/news")
public class newsController {
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private NewsServiceImpl newsServer;

    @RequestMapping("")
    public String chapterHomePage(ModelMap map, Integer newsid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        newsServer.readNews(newsid);
        news News = newsServer.getNewsbyNewsid(newsid);
        map.addAttribute("News", News);
        return "newsPage";
    }
    @RequestMapping("get")
    @ResponseBody
    public List<news> getNews(ModelMap map, Integer studentid){
        List<news> res = newsServer.getNews(studentid);
        return res;
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insertNews(ModelMap map, Integer senderid, Integer receiverid, String title, String content){

        Random r = new Random();
        Integer id = r.nextInt(1000000);
        while(newsServer.getNewsbyNewsid(id)!=null){
            id = r.nextInt(1000000);
        }

        Date date = new Date();
        String strDateFormat = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String time = sdf.format(date);

        newsServer.insertNews(id, senderid, receiverid, title, content, time);
        return "发送成功";
    }
}
