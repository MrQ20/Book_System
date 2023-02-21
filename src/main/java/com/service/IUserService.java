package com.service;


import com.domain.Roles;
import com.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll();

    void save(UserInfo userInfo);

    List<Roles> findUserByIdAndAllRole(Integer id);

    void addRoleToUser(Integer userId,Integer[] roleIds);

    String changePassword(String username, String password, String newPassword);

    UserInfo findById(Integer id);
}
