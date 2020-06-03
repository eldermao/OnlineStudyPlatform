package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.NotifyMapper;
import com.example.springboottest.dao.s_cMapper;
import com.example.springboottest.module.examscore;
import com.example.springboottest.module.notify;
import com.example.springboottest.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private NotifyMapper notifyMapper;

    @Override
    public List<notify> getNotify() {
        try {
            List<notify> res = notifyMapper.getNotify();
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public List<notify> getNotify5() {
        try {
            List<notify> res = notifyMapper.getNotify5();
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public notify getNotifybyNotifyid(Integer notifyid) {
        try {
            notify res = notifyMapper.getNotifybyNotifyid(notifyid);
            return res;
        }
        catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void insertNotify(Integer userid, String title, String content, String pic, Integer notifyid, String time) {
        try {
            notifyMapper.insertNotify(userid, title, content, pic, notifyid, time);
        }
        catch (Exception e) {
            throw e;
        }
    }
}
