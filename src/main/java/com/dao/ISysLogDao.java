package com.dao;

import com.domain.SysLog;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ISysLogDao {
    @Select("select * from syslog")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="visitTime",property="visitTime"),
            @Result(column="ip",property="ip"),
            @Result(column="url",property="url"),
            @Result(column="executionTime",property="executionTime"),
            @Result(column="method",property="method"),
            @Result(column="username",property="username")
    })
    public List<SysLog> findAll();
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog);
   @Delete("delete from syslog where id=#{id}")
    void delete(Integer id);
    @Delete("delete from syslog where 1=1")
    void deleteAll();
}
