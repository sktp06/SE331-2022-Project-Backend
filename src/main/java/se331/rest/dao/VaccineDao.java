package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;

public interface VaccineDao {
    Integer getVaccineSize();
    Page<Vaccine> getVaccines(Integer pageSize, Integer page);
    Vaccine getVaccine(Long id);
    Vaccine save(Vaccine vaccine);
    Page<Vaccine> getVaccines(String name, Pageable pageable);

}
