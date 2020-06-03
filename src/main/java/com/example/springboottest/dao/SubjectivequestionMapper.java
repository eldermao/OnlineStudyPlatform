package com.example.springboottest.dao;

import com.example.springboottest.module.fillinquestion;
import com.example.springboottest.module.subjectivequestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SubjectivequestionMapper {
    @Select("select * from subjectivequestion where examid = #{examid}")
    List<subjectivequestion> getSubjectivequestionInExam(Integer examid);

    @Insert("insert into subjectivequestion values(#{qid}, #{qname}, #{examid}, #{score})")
    void insertSubquestionInExam(Integer qid, String qname, Integer examid, Integer score);

    @Update("update subjectivequestion set qname = #{qname}, score = #{score} where qid = #{qid}")
    void editSubquestionInExam(Integer qid, String qname, Integer score);

    @Delete("delete from subjectivequestion where qid = #{qid}")
    void dltSubquestionInExam(Integer qid);
}
