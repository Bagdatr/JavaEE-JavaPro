package kz.rakhimov.spring_complex_work_cars_marketplace.repositories;

import jakarta.transaction.Transactional;
import kz.rakhimov.spring_complex_work_cars_marketplace.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findAllById(Long id);
}
