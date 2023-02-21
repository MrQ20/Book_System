package com.dao;

import com.domain.Roles;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRolesDao {
    //根据用户id查询所有角色
    @Select("select * from roles where id in (select roleId from users_roles where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
    })
    public List<Roles> findRoleByUserId(String userId) throws Exception;

    @Select("select * from roles")
    List<Roles> findAll();
   @Insert("insert into roles(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Roles role);
}
