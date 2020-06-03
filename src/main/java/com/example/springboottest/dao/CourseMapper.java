package com.example.springboottest.dao;

import com.example.springboottest.module.course;
import com.example.springboottest.module.recommendcourse;
import com.example.springboottest.module.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseMapper {

    @Select("SELECT courseid, coursename, teacherid, username AS teachername, coursepic, `max`\n" +
            "from course natural join p_user \n" +
            "where teacherid = userid")
    List<course> getCourseList();

    @Select("SELECT courseid, coursename, teacherid, username AS teachername, coursepic, `max`\n" +
            "from course natural join p_user \n" +
            "where teacherid = userid and teacherid = #{teacherid}")
    List<course> getCourseListbyTeacherid(Integer teacherid);

    @Select("SELECT courseid, coursename, teacherid, username AS teachername, coursepic, `max`\n" +
            "from course natural join p_user \n" +
            "where teacherid = userid and (LOCATE(#{content},coursename)>0 OR LOCATE(#{content},courseid)>0)")
    List<course> searchCourseList(String content);

    @Select("SELECT courseid, coursename, teacherid, username AS teachername, coursepic, cnt\n" +
            "FROM (SELECT *, COUNT(*) as cnt\n" +
            "FROM student_course NATURAL JOIN course\n" +
            "group BY courseid\n" +
            "LIMIT 5 ) S JOIN p_user P\n" +
            "WHERE teacherid = userid\n" +
            "ORDER BY cnt desc")
    List<recommendcourse> getRecommendCourseList();

    @Select("SELECT courseid, coursename, teacherid, username AS teachername, coursepic, `max`\n" +
            "FROM (SELECT * \n" +
            "FROM course NATURAL JOIN student_course \n" +
            "where studentid = #{studentid}) C natural join p_user \n" +
            "where teacherid = userid")
    List<course> selectedCourseList(Integer studentid);

    @Delete("DELETE FROM student_course WHERE courseid = #{courseid} and studentid = #{studentid}")
    void dropCourse(Integer courseid, Integer studentid);

    @Insert("insert into course values(#{courseid}, #{coursename}, #{teacherid}, #{coursepic}, #{max})")
    void createCourse(Integer courseid, String coursename, Integer teacherid, String coursepic, Integer max);

    @Select("SELECT * from course where courseid = #{courseid}")
    course searchCourseByCourseid(Integer courseid);

    @Insert("insert into student_course values(#{courseid}, #{studentid})")
    void chooseCourse(Integer courseid, Integer studentid);
}
