package kz.bitlab.springsecuritytesting.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.springsecuritytesting.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
