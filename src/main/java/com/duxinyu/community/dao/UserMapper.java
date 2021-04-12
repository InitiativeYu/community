package com.duxinyu.community.dao;

import com.duxinyu.community.entity.User;
import org.springframework.stereotype.Repository;

//让spring装配bean，一般在dao中用@Repository

@Repository
public interface UserMapper {
    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);
    int insertUser(User user);
    int updateStatus(int id,int status);
    int updateHeader(int id,String headerUrl);
    int updatePassword(int id,String password);
}
