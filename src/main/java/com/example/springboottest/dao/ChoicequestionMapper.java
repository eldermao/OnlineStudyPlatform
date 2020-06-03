package com.example.springboottest.dao;

import com.example.springboottest.module.choicequestion;
import com.example.springboottest.module.course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ChoicequestionMapper {
    @Select("select * from choicequestion where crspointid = #{crspointid}")
    List<choicequestion> getChoicequestionInTask(Integer crspointid);

    @Select("select * from choicequestion where examid = #{examid}")
    List<choicequestion> getChoicequestionInExam(Integer examid);

    @Insert("insert into choicequestion values(#{qid}, #{qname}, #{c1}, #{c2}, #{c3}, #{c4}, #{answer}, '0', '0', #{crspointid}, #{score})")
    void insertChoicequestionInTask(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer crspointid, Integer score);

    @Insert("insert into choicequestion values(#{qid}, #{qname}, #{c1}, #{c2}, #{c3}, #{c4}, #{answer}, '1', #{examid}, '0', #{score})")
    void insertChoicequestionInExam(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer examid, Integer score);

    @Select("select * from choicequestion where qid = #{qid}")
    choicequestion searchChoicequestionInTask(Integer qid);

    @Update("update choicequestion set qname = #{qname}, c1 = #{c1}, c2 = #{c2}, c3 = #{c3}, c4 = #{c4}, answer = #{answer}, score = #{score} where qid = #{qid}")
    void editChoicequestionInTask(Integer qid, String qname, String c1, String c2, String c3, String c4, String answer, Integer score);

    @Delete("delete from choicequestion where qid = #{qid}")
    void dltChoicequestionInTask(Integer qid);
}
