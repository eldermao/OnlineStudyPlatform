package com.example.springboottest.dao;

import com.example.springboottest.module.chapter;
import com.example.springboottest.module.course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ChapterMapper {
    @Select("select * from chapter where courseid = #{courseid}")
    List<chapter> searchChapter(Integer courseid);

    @Select("select * from chapter where chapterid = #{chapterid}")
    chapter searchChapterByChapterid(Integer chapterid);

    @Delete("delete from chapter where chapterid = #{chapterid}")
    void dltChapter(Integer chapterid);

    @Insert("insert into chapter values(#{chapterid}, #{chaptername}, #{courseid})")
    void insertChapter(Integer chapterid, String chaptername, Integer courseid);
}
