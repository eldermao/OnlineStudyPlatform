package com.example.springboottest.dao;

import com.example.springboottest.module.fillinquestion;
import com.example.springboottest.module.groupapply;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupapplyMapper {
    @Insert("insert into groupapply values(#{studentid}, #{groupid})")
    void insertGroupapply(Integer studentid, Integer groupid);

    @Select("select * from groupapply where studentid = #{studentid}")
    List<groupapply> getGroupapplyByStudentid(Integer studentid);

    @Select("select * from groupapply where groupid = #{groupid}")
    List<groupapply> getGroupapplyByGroupid(Integer groupid);

    @Delete("delete from groupapply where studentid = #{studentid} and groupid = #{groupid}")
    void dropApplyGroup(Integer studentid, Integer groupid);
}
