package com.example.springboottest.dao;

import com.example.springboottest.module.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ScoreMapper {
    @Select("SELECT C.crspointid, crspointname, if(score IS NULL, 0, 1)as isDone, if(score IS NULL, 0, score)as score\n" +
            "FROM (SELECT * FROM score WHERE studentid = #{studentid}) S RIGHT JOIN (SELECT * from crspoint NATURAL JOIN chapter) C\n" +
            "ON S.crspointid = C.crspointid\n" +
            "WHERE courseid = #{courseid}")
    List<crspointscore> getTestScorebyUserid(Integer courseid, Integer studentid);

    @Select("SELECT exam.examid, examname, if(score IS NULL, 0, 1)as isDone, if(score IS NULL, 0, score)as score\n" +
            "FROM (SELECT * FROM score WHERE studentid = #{studentid}) AS S RIGHT JOIN exam\n" +
            "ON S.examid = exam.examid\n" +
            "WHERE courseid = #{courseid}")
    List<examscore> getExamScorebyUserid(Integer courseid, Integer studentid);

    @Select("SELECT *\n" +
            "FROM score\n" +
            "WHERE examid = #{examid} AND studentid = #{studentid}")
    examscore isStudentExamed(Integer studentid, Integer examid);

    @Insert("insert into score values(#{userid}, #{isexam}, #{subscore}, #{iscorrected}, #{examid}, #{crspointid}, #{score})")
    void insertScore(Integer userid, Integer isexam, Integer subscore, Integer iscorrected, Integer examid, Integer crspointid, Integer score);

    @Insert("insert into sqstudentanswer values(#{qid}, #{studentid}, #{answer}, 0, 0)")
    void insertAnswer(Integer qid, Integer studentid, String answer);

    @Select("SELECT *\n" +
            "FROM score\n" +
            "WHERE studentid = #{studentid} AND crspointid = #{crspointid}")
    crspointscore isStudentScored(Integer studentid, Integer crspointid);

    @Select("SELECT courseid, coursename, username as teachername, `max`, `sum`, `rank`, score\n" +
            "FROM(SELECT *\n" +
            "FROM (SELECT *\n" +
            "FROM (SELECT *, rank() over(partition by courseid order by score desc) AS `rank`\n" +
            "FROM crsscore\n" +
            "WHERE courseid IN (\n" +
            "SELECT courseid\n" +
            "FROM crsscore\n" +
            "WHERE studentid = #{studentid}\n" +
            ")) A NATURAL JOIN \n" +
            "(SELECT courseid, COUNT(*) AS `sum`\n" +
            "FROM crsscore\n" +
            "group BY courseid) B\n" +
            "WHERE studentid = #{studentid}) S NATURAL join course) T , p_user\n" +
            "WHERE T.teacherid = p_user.userid")
    List<coursescore> getCourseScorebyUserid(Integer studentid);

    @Select("SELECT courseid, coursename, username as teachername, `max`, `sum`, `rank`, score\n" +
            "FROM(SELECT *\n" +
            "FROM (SELECT *\n" +
            "FROM (SELECT *, rank() over(partition by courseid order by score desc) AS `rank`\n" +
            "FROM crsscore\n" +
            "WHERE courseid IN (\n" +
            "SELECT courseid\n" +
            "FROM crsscore\n" +
            "WHERE studentid = #{studentid}\n" +
            ")) A NATURAL JOIN \n" +
            "(SELECT courseid, COUNT(*) AS `sum`\n" +
            "FROM crsscore\n" +
            "group BY courseid) B\n" +
            "WHERE studentid = #{studentid}) S NATURAL join course) T , p_user\n" +
            "WHERE T.teacherid = p_user.userid  AND (LOCATE(#{content},courseid)>0 OR LOCATE(#{content},coursename)>0 OR LOCATE(#{content},username)>0)")
    List<coursescore> searchCourseScorebyUserid(Integer studentid, String content);

    @Insert("insert into crsscore values(#{studentid}, #{courseid}, #{score})")
    void courseScroeInsert(Integer studentid, Integer courseid, Integer score);

    @Select("SELECT *\n" +
            "FROM crsscore\n" +
            "WHERE courseid = #{courseid} AND studentid = #{studentid}")
    coursescore getCourseScore(Integer studentid, Integer courseid);
}
