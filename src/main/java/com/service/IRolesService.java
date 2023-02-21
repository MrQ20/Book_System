package com.service;

import com.domain.Roles;

import java.util.List;

public interface IRolesService {
    List<Roles> findAll();

    void save(Roles role);
}
