package com.api.classroom_management.role;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table
@NoArgsConstructor
public class RoleModel implements GrantedAuthority {

    public RoleModel(RoleName roleName) {
        this.roleName = roleName;
    }

    @Id
    @SequenceGenerator(name = "role_sequence" , sequenceName = "role_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    private Long roleId;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;



    @Override
    public String getAuthority() {
        return this.roleName.toString() ;
    }
}
