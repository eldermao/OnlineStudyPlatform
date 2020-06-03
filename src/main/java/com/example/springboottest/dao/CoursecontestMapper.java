package com.example.springboottest.dao;

import com.example.springboottest.module.coursecontest;
import com.example.springboottest.module.exam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CoursecontestMapper {
    @Select("SELECT * FROM exam where courseid = #{courseid} and iscontest = 1")
    List<coursecontest> getCoursecontestbyCourseid(Integer courseid);


}
