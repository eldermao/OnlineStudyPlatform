package com.example.springboottest.dao;

import com.example.springboottest.module.studentchart;
import com.example.springboottest.module.subjectivequestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentchartMapper {

    @Insert("insert into studentchart values(#{studentid}, #{courseid}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)")
    void insertChart(Integer studentid, Integer courseid);

    @Select("select * from studentchart where studentid = #{studentid} and courseid = #{courseid}")
    studentchart getStudentchart(Integer studentid, Integer courseid);

    @Update("update studentchart set choicescore = choicescore + #{choicescore}, choicesum = choicesum + #{choicesum}, qscore = qscore + #{choicescore}, qsum = qsum + #{choicesum} where studentid = #{studentid} and courseid = #{courseid}")
    void updatechoice(Integer studentid, Integer courseid, Integer choicescore, Integer choicesum);

    @Update("update studentchart set tfscore = tfscore + #{tfscore}, tfsum = tfsum + #{tfsum}, qscore = qscore + #{tfscore}, qsum = qsum + #{tfsum} where studentid = #{studentid} and courseid = #{courseid}")
    void updatetf(Integer studentid, Integer courseid, Integer tfscore, Integer tfsum);

    @Update("update studentchart set fillinscore = fillinscore + #{fillinscore}, fillinsum = fillinsum + #{fillinsum}, qscore = qscore + #{fillinscore}, qsum = qsum + #{fillinsum} where studentid = #{studentid} and courseid = #{courseid}")
    void updatefillin(Integer studentid, Integer courseid, Integer fillinscore, Integer fillinsum);

    @Update("update studentchart set sqscore = sqscore + #{sqscore}, sqsum = sqsum + #{sqsum}, qscore = qscore + #{sqscore}, qsum = qsum + #{sqsum} where studentid = #{studentid} and courseid = #{courseid}")
    void updatesq(Integer studentid, Integer courseid, Integer sqscore, Integer sqsum);
}
