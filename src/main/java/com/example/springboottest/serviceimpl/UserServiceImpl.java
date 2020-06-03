package com.example.springboottest.serviceimpl;

import com.example.springboottest.dao.UserMapper;
import com.example.springboottest.module.notify;
import com.example.springboottest.service.UserService;
import com.example.springboottest.module.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<user> getUserList() {

        try {
            List<user> users = userMapper.getUserList();

            return  users;
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public List<user> findUser(String username) {
        try {
            List<user> users = userMapper.findUser(username);

            return  users;
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public void insertUser(user User) {
        try {
            userMapper.insertUser(User.getUserid(), User.getUsername(), User.getUserpassword(), User.getUserage(), User.getUserphone(), User.getUseremail() );
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public user findUserById(Integer userid) {
        try {
            //System.out.println("debug here");
            //System.out.println(userid);
             return userMapper.findUserById(userid);
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public void updateUser(user User) {
        try {
            userMapper.updateUser(User.getUserid(), User.getUsername(), User.getUserage(), User.getUserphone(), User.getUseremail());
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public user loginUser(Integer userid, String password) {
        try {
            return userMapper.loginUser(userid, password);
        }
        catch (Exception e)
        {
            throw e;
//            return null;
        }
    }

    @Override
    public List<user> getUserListbyCourseid(Integer courseid) {
        try {
            List<user> res = userMapper.getUserListbyCourseid(courseid);
            return res;
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void updateProfile(Integer userid, String profile) {
        try {
            userMapper.updateProfile(userid, profile);
        }
        catch (Exception e)
        {
            throw e;
        }
    }

    @Override
    public void updatePassword(Integer userid, String password) {
        try {
            userMapper.updatePassword(userid, password);
        }
        catch (Exception e)
        {
            throw e;
        }
    }
}