package kz.bitlab.trello.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.trello.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
