package com.example.springboottest.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface s_gMapper {
    @Insert("insert into student_group values(#{studentid}, #{groupid})")
    void insertS_g(Integer studentid, Integer groupid);

    @Delete("delete from student_group where studentid = #{studentid} and groupid = #{groupid}")
    void dltS_g(Integer studentid, Integer groupid);

    @Delete("delete from student_group where groupid = #{groupid}")
    void dismissGroup(Integer groupid);
}
