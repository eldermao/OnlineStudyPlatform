package com.example.springboottest.dao;

import com.example.springboottest.module.exam;
import com.example.springboottest.module.group;
import com.example.springboottest.module.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GroupMapper {
    @Select("SELECT * FROM `group` where courseid = #{courseid}")
    List<group> searchGroupByCourseid(Integer courseid);

    @Select("SELECT groupid, groupname, leaderid, leadername, courseid, coursename, studentid\n" +
            "FROM (SELECT groupid, groupname, leaderid, username AS leadername, courseid, studentid\n" +
            "FROM (SELECT * FROM `group` natural join groupapply where studentid = #{studentid}) S , p_user\n" +
            "WHERE S.leaderid = p_user.userid) S NATURAL JOIN course\n")
    List<group> searchApplyGroupByStudentid(Integer studentid);

    @Select("SELECT * FROM `group` where groupid = #{groupid}")
    group searchGroupByGroupid(Integer groupid);

    @Select("SELECT groupid, groupname, leaderid, leadername, courseid, coursename\n" +
            "FROM (SELECT groupid, groupname, leaderid, username AS leadername, courseid\n" +
            "FROM (SELECT * FROM `group` where leaderid = #{leaderid}) S , p_user\n" +
            "WHERE S.leaderid = p_user.userid) S NATURAL JOIN course\n")
    List<group> searchGroupByLeaderid(Integer leaderid);

    @Select("SELECT groupid, groupname, leaderid, leadername, courseid, coursename, studentid\n" +
            "FROM (SELECT groupid, groupname, leaderid, username AS leadername, courseid, studentid\n" +
            "FROM (SELECT * FROM `group` natural join student_group where studentid = #{studentid} and leaderid != #{studentid}) S , p_user\n" +
            "WHERE S.leaderid = p_user.userid) S NATURAL JOIN course\n")
    List<group> searchGroupByStudentid(Integer studentid);

    @Insert("insert into `group` values(#{groupid}, #{groupname}, #{leaderid}, #{courseid})")
    void insertGroup(Integer groupid, String groupname, Integer leaderid, Integer courseid);

    @Select("select count(*) from `group`")
    int getSumofGroup();

    @Select("SELECT * FROM `group` natural join student_group where courseid = #{courseid} and studentid = #{studentid}")
    group isGrouped(Integer courseid, Integer studentid);

    @Select("SELECT * FROM student_group a natural join p_user b where groupid = #{groupid} and a.studentid = b.userid")
    List<user> getMemberlist(Integer groupid);

    @Select("SELECT * FROM groupapply a natural join p_user b where groupid = #{groupid} and a.studentid = b.userid")
    List<user> getApplyMemberlist(Integer groupid);

    @Delete("delete from `group` where groupid = #{groupid}")
    void dismissGroup(Integer groupid);

    @Update("update `group` set leaderid = #{studentid} where groupid = #{groupid}")
    void riseMember(Integer studentid, Integer groupid);
}
