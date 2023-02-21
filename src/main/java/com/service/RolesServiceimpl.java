package com.service;

import com.dao.IRolesDao;
import com.domain.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RolesServiceimpl implements IRolesService {
    @Autowired
    private IRolesDao dao;
    @Override
    public List<Roles> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Roles role) {
        dao.save(role);
    }
}
