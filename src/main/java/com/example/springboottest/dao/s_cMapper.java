package com.example.springboottest.dao;

import com.example.springboottest.module.course;
import com.example.springboottest.module.s_c;
import com.example.springboottest.module.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface s_cMapper {

    @Select("select * from student_course where courseid = #{courseid} and studentid = #{studentid}")
    s_c findS_c(Integer courseid, Integer studentid);

    @Delete("delete from student_course where studentid = #{studentid} and courseid = #{courseid}")
    void dltS_c(Integer courseid, Integer studentid);

}
