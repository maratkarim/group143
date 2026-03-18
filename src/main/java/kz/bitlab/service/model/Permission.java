package kz.bitlab.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Setter
@Getter
@Table(name = "t_permissions")
public class Permission extends BaseEntity implements GrantedAuthority {

    @Column(name = "permission")
    private String permission;

    @Override
    public String getAuthority() {
        return permission;
    }
}
