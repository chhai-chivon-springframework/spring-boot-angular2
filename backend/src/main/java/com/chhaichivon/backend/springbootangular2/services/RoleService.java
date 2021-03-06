package com.chhaichivon.backend.springbootangular2.services;

import com.chhaichivon.backend.springbootangular2.models.Role;
import com.chhaichivon.backend.springbootangular2.repositoties.RoleRepository;
import com.chhaichivon.backend.springbootangular2.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * AUTHOR : CHHAI CHIVON
 * EMAIL  : chhaichivon1995@gmail.com
 * DATE   : 8/7/2017
 * TIME   : 9:14 AM
 */

@Service
public class RoleService implements BaseService<Role>{
    @Autowired
    private RoleRepository roleRepository;

    public Page<Role> findAll(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }
    @Override
    public Role findById(long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void update(Role entity) {
        roleRepository.save(entity);
    }

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }
}
