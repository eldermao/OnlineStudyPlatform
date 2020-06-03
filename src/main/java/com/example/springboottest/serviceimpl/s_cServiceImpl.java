package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.CourseMapper;
import com.example.springboottest.dao.s_cMapper;
import com.example.springboottest.module.s_c;
import com.example.springboottest.service.s_cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class s_cServiceImpl implements s_cService {
    @Autowired
    private s_cMapper S_cMapper;
    public s_c findS_c(Integer courseid, Integer studentid){
        return S_cMapper.findS_c(courseid, studentid);
    }
}
