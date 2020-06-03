package com.example.springboottest.dao;

import com.example.springboottest.module.user;
import com.example.springboottest.module.vedio;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VedioMapper {
    @Select("select * from vedio where crspointid = #{crspointid}")
    vedio searchVedio(Integer crspointid);
}
