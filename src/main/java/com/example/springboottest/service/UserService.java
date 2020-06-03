package com.example.springboottest.service;

import java.util.List;
import com.example.springboottest.module.user;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    List<user> getUserList();
    List<user> findUser(String username);
    void insertUser(user User);
    user findUserById(Integer userid);
    void updateUser(user User);
    user loginUser(Integer userid, String userpassword);
    List<user> getUserListbyCourseid(Integer courseid);

    void updateProfile(Integer userid, String profile);
    void updatePassword(Integer userid, String password);
}
