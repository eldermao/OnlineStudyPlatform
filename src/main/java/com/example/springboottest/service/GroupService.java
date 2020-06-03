package com.example.springboottest.service;

import com.example.springboottest.module.group;
import com.example.springboottest.module.user;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {
    List<group> searchGroupByCourseid(Integer courseid);
    group searchGroupByGroupid(Integer groupid);
    void insertGroup(Integer groupid, String groupname, Integer leaderid, Integer courseid);
    int getSumofGroup();
    group isGrouped(Integer courseid, Integer studentid);
    void quitGroup(Integer groupid, Integer studentid);
    void applyGroup(Integer studentid , Integer groupid);
    void dropApplyGroup(Integer studentid , Integer groupid);
    void dismissGroup(Integer groupid);
    void acceptApplyGroup(Integer studentid, Integer groupid);
    void rejectApplyGroup(Integer studentid, Integer groupid);
    List<group> searchApplyGroupByStudentid(Integer studentid);
    List<group> searchGroupByStudentid(Integer studentid);
    List<group> searchGroupByLeaderid(Integer leaderid);
    List<user> getApplyMemberlist(Integer groupid);
    List<user> getMemberlist(Integer groupid);

    void riseMember(Integer studentid, Integer groupid);
    void popMember(Integer studentid, Integer groupid);
}
