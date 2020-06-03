package com.example.springboottest.dao;

import com.example.springboottest.module.course;
import com.example.springboottest.module.task;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskMapper {
    @Select("select * from task where crspointid = #{crspointid}")
    task getTask(Integer crspointid);
}
