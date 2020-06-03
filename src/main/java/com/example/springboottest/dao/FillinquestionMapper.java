package com.example.springboottest.dao;

import com.example.springboottest.module.choicequestion;
import com.example.springboottest.module.fillinquestion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FillinquestionMapper {
    @Select("select * from fillinquestion where crspointid = #{crspointid}")
    List<fillinquestion> getFillinquestionInTask(Integer crspointid);

    @Select("select * from fillinquestion where examid = #{examid}")
    List<fillinquestion> getFillinquestionInExam(Integer examid);

    @Insert("insert into fillinquestion values(#{qid}, #{qname}, #{answer}, '0', '0', #{taskid}, #{score})")
    void insertFillinquestionInTask(Integer qid, String qname, String answer, Integer taskid, Integer score);

    @Insert("insert into fillinquestion values(#{qid}, #{qname}, #{answer}, '1', #{examid}, '0', #{score})")
    void insertFillinquestionInExam(Integer qid, String qname, String answer, Integer examid, Integer score);

    @Select("select * from fillinquestion where qid = #{qid}")
    fillinquestion searchFillinquestionInTask(Integer qid);

    @Update("update fillinquestion set qname = #{qname}, answer = #{answer}, score = #{score} where qid = #{qid}")
    void editFillinquestion(Integer qid, String qname, String answer, Integer score);

    @Delete("delete from fillinquestion where qid = #{qid}")
    void dltFillinquestion(Integer qid);
}
