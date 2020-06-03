package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.ExamMapper;
import com.example.springboottest.dao.GroupMapper;
import com.example.springboottest.dao.GroupapplyMapper;
import com.example.springboottest.dao.s_gMapper;
import com.example.springboottest.module.group;
import com.example.springboottest.module.user;
import com.example.springboottest.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private s_gMapper sGMapperMapper;
    @Autowired
    private GroupapplyMapper groupapplyMapper;
    @Override
    public List<group> searchGroupByCourseid(Integer courseid) {
        try{
            return groupMapper.searchGroupByCourseid(courseid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public group searchGroupByGroupid(Integer groupid) {
        return null;
    }

    @Override
    public void insertGroup(Integer groupid, String groupname, Integer leaderid, Integer courseid) {
        try{
            groupMapper.insertGroup(groupid, groupname, leaderid, courseid);
            sGMapperMapper.insertS_g(leaderid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public int getSumofGroup() {
        try{
            return groupMapper.getSumofGroup();
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public group isGrouped(Integer courseid, Integer studentid) {
        try{
            return groupMapper.isGrouped(courseid, studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void quitGroup(Integer groupid, Integer studentid) {
        try{
            sGMapperMapper.dltS_g(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void applyGroup(Integer studentid, Integer groupid) {
        try{
            groupapplyMapper.insertGroupapply(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dropApplyGroup(Integer studentid, Integer groupid) {
        try{
            groupapplyMapper.dropApplyGroup(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void dismissGroup(Integer groupid) {
        try{
            groupMapper.dismissGroup(groupid);
            sGMapperMapper.dismissGroup(groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void acceptApplyGroup(Integer studentid, Integer groupid) {
        try{
            groupapplyMapper.dropApplyGroup(studentid, groupid);
            sGMapperMapper.insertS_g(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void rejectApplyGroup(Integer studentid, Integer groupid) {
        try{
            groupapplyMapper.dropApplyGroup(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<group> searchApplyGroupByStudentid(Integer studentid) {
        try{
            return groupMapper.searchApplyGroupByStudentid(studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<group> searchGroupByStudentid(Integer studentid) {
        try{
            return groupMapper.searchGroupByStudentid(studentid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<group> searchGroupByLeaderid(Integer leaderid) {
        try{
            return groupMapper.searchGroupByLeaderid(leaderid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<user> getApplyMemberlist(Integer groupid) {
        try{
            return groupMapper.getApplyMemberlist(groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public List<user> getMemberlist(Integer groupid) {
        try{
            return groupMapper.getMemberlist(groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void riseMember(Integer studentid, Integer groupid) {
        try{
            groupMapper.riseMember(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void popMember(Integer studentid, Integer groupid) {
        try{
            sGMapperMapper.dltS_g(studentid, groupid);
        }catch(Exception e){
            throw e;
        }
    }
}
