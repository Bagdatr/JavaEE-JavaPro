package kz.bagdat.springboot_tables_bunch.repositories;

import kz.bagdat.springboot_tables_bunch.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository <Countries, Long> {
}
