package com.example.springboottest.Controller;

import com.example.springboottest.module.user;
import com.example.springboottest.serviceimpl.GroupServiceImpl;
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
import java.util.Random;

@Controller
@RequestMapping("/group")
public class groupController {
    @Autowired
    private UserServiceImpl userServer;
    @Autowired
    private GroupServiceImpl groupServer;
    @Autowired
    private RankServiceImpl rankServer;
    @RequestMapping("insert")
    @ResponseBody
    public String insertGroup(ModelMap map, String groupname, Integer leaderid, Integer courseid){
        Random r = new Random();
        Integer groupid = r.nextInt(1000000);
        while(groupServer.searchGroupByGroupid(groupid)!=null){
            groupid = r.nextInt(1000000);
        }
        groupServer.insertGroup(groupid, groupname, leaderid, courseid);
        rankServer.insertGroupRank(groupid);
        return "添加小组成功";
    }

    @RequestMapping("apply")
    @ResponseBody
    public String applyGroup(ModelMap map, Integer groupid, Integer studentid){

        groupServer.applyGroup(studentid, groupid);
        return "申请成功，等待接受";
    }

    @RequestMapping("dropapply")
    @ResponseBody
    public String dropApplyGroup(ModelMap map, Integer groupid, Integer studentid){

        groupServer.dropApplyGroup(studentid, groupid);
        return "放弃申请成功";
    }

    @RequestMapping("quit")
    @ResponseBody
    public String quitGroup(ModelMap map, Integer groupid, Integer studentid){

        groupServer.quitGroup(groupid, studentid);
        return "退出小组成功";
    }

    @RequestMapping("getapply")
    @ResponseBody
    public List<user> getapplyGroup(ModelMap map, Integer groupid){

        List<user> applylist = groupServer.getApplyMemberlist(groupid);
        return applylist;
    }

    @RequestMapping("getmember")
    @ResponseBody
    public List<user> getMemberGroup(ModelMap map, Integer groupid){

        List<user> memberlist = groupServer.getMemberlist(groupid);
        return memberlist;
    }

    @RequestMapping("dismiss")
    @ResponseBody
    public String dismissGroup(ModelMap map, Integer groupid){

        groupServer.dismissGroup(groupid);
        return "解散小组成功";
    }

    @RequestMapping("accept")
    @ResponseBody
    public String acceptApplyGroup(ModelMap map,Integer studentid, Integer groupid){

        groupServer.acceptApplyGroup(studentid, groupid);
        return "接受申请成功";
    }

    @RequestMapping("reject")
    @ResponseBody
    public String rejectApplyGroup(ModelMap map,Integer studentid, Integer groupid){

        groupServer.rejectApplyGroup(studentid, groupid);
        return "拒绝申请成功";
    }

    @RequestMapping("rise")
    @ResponseBody
    public String riseMember(ModelMap map,Integer studentid, Integer groupid){

        groupServer.riseMember(studentid, groupid);
        return "提升为组长成功";
    }

    @RequestMapping("pop")
    @ResponseBody
    public String popMember(ModelMap map,Integer studentid, Integer groupid){

        groupServer.riseMember(studentid, groupid);
        return "请出成员成功";
    }
}
