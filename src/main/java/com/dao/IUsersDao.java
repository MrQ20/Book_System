package com.dao;

import com.domain.Roles;
import com.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface IUsersDao {
    @Select("select * from users")
  public List<UserInfo> findAll();

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "statu", column = "statu"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dao.IRolesDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username);

    @Insert("insert into users(email,username,password,statu)values(#{email},#{username},#{password},#{statu})")
    void save(UserInfo userInfo);
  @Select("select * from roles where id not in(select roleId from users_roles where userId=#{id})")
  List<Roles> findUserByIdAndAllRole(Integer id);
@Insert("insert into users_roles(userId,roleId)values(#{userId},#{roleId})")
  void addRoleToUser(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

   @Update("update users set password=#{password} where username=#{username}")
  void changePassword(@Param("username") String username,@Param("password") String newPassword);
   @Select("select * from users where id=#{id}")
   @Results({
           @Result(id = true, column = "id", property = "id"),
           @Result(property = "username", column = "username"),
           @Result(property = "email", column = "email"),
           @Result(property = "password", column = "password"),
           @Result(property = "phoneNum", column = "phoneNum"),
           @Result(property = "status", column = "status"),
           @Result(property = "roles", column = "id", javaType = java.util.List.class, many = @Many(select = "com.dao.IRolesDao.findRoleByUserId"))
   })
  UserInfo findById(Integer id);
}
