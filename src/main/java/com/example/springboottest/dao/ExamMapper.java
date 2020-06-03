package com.example.springboottest.dao;

import com.example.springboottest.module.choicequestion;
import com.example.springboottest.module.course;
import com.example.springboottest.module.exam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExamMapper {
    @Select("SELECT *\n" +
            "FROM (SELECT * \n" +
            "FROM exam NATURAL JOIN student_course \n" +
            "where studentid = #{studentid} and iscontest = 0) E NATURAL JOIN course")
    List<exam> ExamList(Integer studentid);

    @Select("SELECT * FROM exam where examid = #{examid}")
    exam searchExam(Integer examid);

    @Select("SELECT * FROM exam where courseid = #{courseid} and iscontest = 0")
    List<exam> getExamListbyCourseid(Integer courseid);

    @Update("update exam set examname = #{examname}, starttime = #{starttime}, endtime = #{endtime} where examid = #{examid}")
    void editExam(Integer examid, String examname, Integer starttime, Integer endtime);

    @Delete("delete from exam where examid = #{examid}")
    void dltExam(Integer examid);

    @Insert("insert into exam values(#{examid}, #{examname}, 0, #{courseid}, #{starttime}, #{endtime})")
    void insertExam(Integer examid, String examname, Integer starttime, Integer endtime, Integer courseid);

    @Insert("insert into exam values(#{examid}, #{examname}, 1, #{courseid}, 0, 0)")
    void insertContest(Integer examid, String examname, Integer courseid);
}
