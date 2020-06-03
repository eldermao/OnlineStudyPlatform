package com.example.springboottest.dao;

import com.example.springboottest.module.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    @Select("select * from p_user")
    List<user> getUserList();

    @Select("SELECT * \n" +
            "from student_course natrual join p_user\n" +
            "WHERE studentid = userid AND courseid = #{courseid}")
    List<user> getUserListbyCourseid(Integer courseid);

    @Select("select * from p_user where username = #{username}")
    List<user> findUser(String username);

    @Insert("insert into p_user values(#{userid}, #{username}, #{userpassword}, #{userage}, #{userphone}, #{useremail}, '0.png')")
    void insertUser(Integer userid, String username, String userpassword, Integer userage, String userphone, String useremail);

    @Select("select * from p_user where userid = #{userid}")
    user findUserById(Integer userid);

    @Select("select * from p_user where userid = #{userid} and userpassword = #{userpassword}")
    user loginUser(Integer userid, String userpassword);

    @Update("update p_user set username = #{username}, userage = #{userage}, userphone = #{userphone}, useremail = #{useremail} where userid = #{userid}")
    void updateUser(Integer userid, String username, Integer userage, String userphone, String useremail);

    @Update("update p_user set profile = #{profile} where userid = #{userid}")
    void updateProfile(Integer userid, String profile);

    @Update("update p_user set userpassword = #{userpassword} where userid = #{userid}")
    void updatePassword(Integer userid, String userpassword);
}