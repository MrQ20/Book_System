package com.service;

import com.dao.ISysLogDao;
import com.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao dao;
    public void save(SysLog sysLog){
        dao.save(sysLog);

    }

    @Override
    public List<SysLog> findAll() {
        return dao.findAll();
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    ;
}
