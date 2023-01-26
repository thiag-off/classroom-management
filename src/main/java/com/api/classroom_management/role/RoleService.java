package com.api.classroom_management.role;

import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public void addNewRole(RoleModel role){

        roleRepository.save(role);

    }

    public RoleModel getRoleById(Long roleId){
        return roleRepository.findById(roleId).orElseThrow(()->new IllegalStateException("ROLE NOT FOUND"));
    }
}
