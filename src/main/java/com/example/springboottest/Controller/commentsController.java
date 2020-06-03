package com.example.springboottest.Controller;

import com.example.springboottest.module.course;
import com.example.springboottest.serviceimpl.CommentsServiceImpl;
import com.example.springboottest.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comments")
public class commentsController {
    @Autowired
    private CommentsServiceImpl commentsServer;
    @Autowired
    private UserServiceImpl userServer;
    @RequestMapping("/add")
    @ResponseBody
    public String addComments(ModelMap map, Integer crspointid, Integer userid, String content)
    {
        commentsServer.addComment(crspointid, userid, content);
        return "评论成功";
    }
    @RequestMapping("/reply")
    @ResponseBody
    public String addReply(ModelMap map, Integer commentsid, Integer userid, String content)
    {
        commentsServer.addReply(commentsid, userid, content);
        return "回复成功";
    }
}
