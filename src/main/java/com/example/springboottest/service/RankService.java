package com.example.springboottest.service;

import com.example.springboottest.module.grouprank;
import com.example.springboottest.module.studentrank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RankService {
    List<studentrank> getStudentRank();
    studentrank getStudentRankbyStudentid(Integer studentid);
    List<grouprank> getGroupRank();
    void insertStudentRank(Integer studentid);
    void insertGroupRank(Integer groupid);
    void increaseStudentRank(Integer studentid);
    void increaseGroupRank(Integer groupid);
}
