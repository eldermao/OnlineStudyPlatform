package com.example.springboottest.Controller;

import com.example.springboottest.module.*;
import com.example.springboottest.serviceimpl.NotifyServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/notify")
public class notifyController {
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private NotifyServiceImpl notifyServer;
    @RequestMapping("")
    public String notifyPage(ModelMap map, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        List<notify> notifyList = notifyServer.getNotify();
        map.addAttribute("notifyList", notifyList);
        return "notifyHomePage";
    }

    @RequestMapping("search")
    public String searchnotifyPage(ModelMap map, Integer notifyid, @CookieValue(value = "userid",defaultValue = "0") Integer userid, @CookieValue(value = "userpassword",defaultValue = "0") String userpassword) throws MissingRequestCookieException
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
        notify notify = notifyServer.getNotifybyNotifyid(notifyid);
        map.addAttribute("notify", notify);
        return "notifyPage";
    }

    @RequestMapping("insert")
    @ResponseBody
    public String insertNotify(Integer userid, String title, String content, MultipartFile imgfile){
        Random r = new Random();
        Integer notifyid = r.nextInt(1000000);
        while(notifyServer.getNotifybyNotifyid(notifyid)!=null){
            notifyid = r.nextInt(1000000);
        }
        String originalFilename = imgfile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String headpath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\notify\\";
        String Filename = notifyid + substring;
        File uploadFile = new File(headpath+Filename);
        System.out.println(uploadFile);
        try {
            imgfile.transferTo(uploadFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Date date = new Date();
        String strDateFormat = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String time = sdf.format(date);

        notifyServer.insertNotify(userid, title, content, Filename, notifyid, time);
        return "success";
    }
}
