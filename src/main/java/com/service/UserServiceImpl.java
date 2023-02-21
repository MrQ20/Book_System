package com.service;

import com.dao.IUsersDao;
import com.domain.Roles;
import com.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUsersDao dao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserInfo> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        dao.save(userInfo);
    }

    @Override
    public List<Roles> findUserByIdAndAllRole(Integer id) {
        return dao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] roleIds) {
        for(Integer roleId:roleIds){
            dao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public String changePassword(String username, String password, String newPassword)  {
      UserInfo userInfo= dao.findByUsername(username);
           boolean flag=bCryptPasswordEncoder.matches(password,userInfo.getPassword());
           if(flag){
             String encodePassword  =bCryptPasswordEncoder.encode(newPassword);
               dao.changePassword(username,encodePassword);
               return "/login.jsp";
           }
        return "/errorPassword.jsp";

    }

    @Override
    public UserInfo findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = dao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatu() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));


        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Roles> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Roles role : roles) {
            String roleName = "ROLE_" + role.getRoleName();
            list.add(new SimpleGrantedAuthority(roleName));
        }

        return list;
    }
}
