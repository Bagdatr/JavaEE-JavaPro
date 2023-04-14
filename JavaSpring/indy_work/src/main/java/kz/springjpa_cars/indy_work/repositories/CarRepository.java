package kz.springjpa_cars.indy_work.repositories;

import kz.springjpa_cars.indy_work.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CarRepository extends JpaRepository<Car,Long> {
}
