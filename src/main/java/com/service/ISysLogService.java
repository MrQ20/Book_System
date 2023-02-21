package com.service;

import com.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    public void save(SysLog sysLog);

    List<SysLog> findAll();

    void delete(Integer id);

    void deleteAll();
}
