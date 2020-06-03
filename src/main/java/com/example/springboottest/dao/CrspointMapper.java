package com.example.springboottest.dao;

import com.example.springboottest.module.chapter;
import com.example.springboottest.module.course;
import com.example.springboottest.module.crspoint;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CrspointMapper {
    @Select("SELECT *\n" +
            "FROM chapter NATURAL JOIN course\n" +
            "WHERE chapterid = (\n" +
            "SELECT chapterid\n" +
            "FROM crspoint NATURAL JOIN chapter\n" +
            "WHERE crspointid = #{crspointid})")
    course getCoursebyCrspointid(Integer crspointid);

    @Select("select * from crspoint where chapterid = #{chapterid}")
    List<crspoint> searchCrspoint(Integer chapterid);

    @Insert("insert into crspoint values(#{crspointid}, #{crspointname}, #{chapterid})")
    void insertCrspoint(Integer crspointid, String crspointname, Integer chapterid);

    @Update("update crspoint set crspointname = #{crspointname} where crspointid = #{crspointid}")
    void updateCrspoint(Integer crspointid, String crspointname);
}
