package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.NotifyMapper;
import com.example.springboottest.dao.RankMapper;
import com.example.springboottest.module.grouprank;
import com.example.springboottest.module.notify;
import com.example.springboottest.module.studentrank;
import com.example.springboottest.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankServiceImpl implements RankService {
    @Autowired
    private RankMapper rankMapper;

    @Override
    public List<studentrank> getStudentRank() {
        try {
            List<studentrank> res = rankMapper.getStudentRank();
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public studentrank getStudentRankbyStudentid(Integer studentid) {
        try {
            studentrank res = rankMapper.getStudentRankbyStudentid(studentid);
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public List<grouprank> getGroupRank() {
        try {
            List<grouprank> res = rankMapper.getGroupRank();
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void insertStudentRank(Integer studentid) {
        try {
            rankMapper.insertStudentRank(studentid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void insertGroupRank(Integer groupid) {
        try {
            rankMapper.insertGroupRank(groupid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void increaseStudentRank(Integer studentid) {
        try {
            rankMapper.increaseStudentRank(studentid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void increaseGroupRank(Integer groupid) {
        try {
            rankMapper.increaseGroupRank(groupid);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}
