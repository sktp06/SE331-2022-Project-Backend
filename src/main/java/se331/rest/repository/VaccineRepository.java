package se331.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;

import java.util.List;

public interface VaccineRepository extends JpaRepository<Vaccine,Long> {
    List<Vaccine> findAll();
    Page<Vaccine> findByName(String name, Pageable pageRequest);
}
