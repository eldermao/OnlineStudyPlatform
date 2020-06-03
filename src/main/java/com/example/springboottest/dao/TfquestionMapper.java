package com.example.springboottest.dao;

import com.example.springboottest.module.fillinquestion;
import com.example.springboottest.module.tfquestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TfquestionMapper {
    @Select("select * from tfquestion where crspointid = #{crspointid}")
    List<tfquestion> getTfquestionInTask(Integer crspointid);

    @Select("select * from tfquestion where examid = #{examid}")
    List<tfquestion> getTfquestionInExam(Integer examid);

    @Insert("insert into tfquestion values(#{qid}, #{qname}, #{answer}, '0', '0', #{crspointid}, #{score})")
    void insertTfquestionInTask(Integer qid, String qname, String answer, Integer crspointid, Integer score);

    @Insert("insert into tfquestion values(#{qid}, #{qname}, #{answer}, '1', #{examid}, '0', #{score})")
    void insertTfquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score);

    @Select("select * from tfquestion where qid = #{qid}")
    tfquestion searchTfquestionInTask(Integer qid);

    @Update("update tfquestion set qname = #{qname}, answer = #{answer}, score = #{score} where qid = #{qid}")
    void editTfquestionInTask(Integer qid, String qname, String answer, Integer score);

    @Delete("delete from tfquestion where qid = #{qid}")
    void dltTfquestionInTask(Integer qid);
}
