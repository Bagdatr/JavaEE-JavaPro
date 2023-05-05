package indipendentwork.java.spring.security.repositories;

import indipendentwork.java.spring.security.entities.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
