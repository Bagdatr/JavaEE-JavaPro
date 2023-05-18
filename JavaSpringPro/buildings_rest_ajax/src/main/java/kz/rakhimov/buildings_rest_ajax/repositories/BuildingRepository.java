package kz.rakhimov.buildings_rest_ajax.repositories;

import jakarta.transaction.Transactional;
import kz.rakhimov.buildings_rest_ajax.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BuildingRepository extends JpaRepository<Building,Long> {
    Building findAllById(Long id);
}
