package indipendentwork.java.spring.security.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="t_permissions")
@Getter
@Setter
public class Permission extends BaseEntity implements GrantedAuthority{
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
