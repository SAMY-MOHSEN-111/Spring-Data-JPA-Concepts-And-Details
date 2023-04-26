package com.global.hr.service;

import com.global.hr.entity.Role;
import com.global.hr.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public void wireRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(long id) {
        // could be handled better than that XD
        return roleRepository.findById(id).orElse(null);
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public List<Role> save(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    public Role update(Role role) {
        Optional<Role> optionalAccount = roleRepository.findById(role.getId());
        if (optionalAccount.isEmpty()) throw new RuntimeException("Role not found");

        Role dbRole = optionalAccount.get();
        dbRole.setName(role.getName());

        return roleRepository.save(dbRole);
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
}
