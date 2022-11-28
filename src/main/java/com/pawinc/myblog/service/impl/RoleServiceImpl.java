package com.pawinc.myblog.service.impl;

import com.pawinc.myblog.model.Role;
import com.pawinc.myblog.repository.RoleRepository;
import com.pawinc.myblog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        Assert.notNull(role, "Role cannot be null");
        return roleRepository.save(role);
    }

    @Override
    public Role readById(long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role with id=" + id + " not found"));
    }

    @Override
    public Role update(Role role) {
        Assert.notNull(role, "Role cannot be null");
        roleRepository.findById(role.getId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        return roleRepository.save(role);
    }

    @Override
    public void delete(long id) {
        roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role with id=" + id + " not found"));
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.isEmpty() ? new ArrayList<>() : roles;
    }
}
