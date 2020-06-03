package com.example.springboottest.service;

import com.example.springboottest.module.notify;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NotifyService {
    List<notify> getNotify();
    List<notify> getNotify5();
    notify getNotifybyNotifyid(Integer notifyid);
    void insertNotify(Integer userid, String title, String content, String pic, Integer notifyid, String time );
}
