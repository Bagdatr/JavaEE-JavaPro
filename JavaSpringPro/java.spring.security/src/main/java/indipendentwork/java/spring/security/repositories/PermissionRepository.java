package indipendentwork.java.spring.security.repositories;

import indipendentwork.java.spring.security.entities.Permission;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}
