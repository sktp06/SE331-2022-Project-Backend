package se331.rest.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.entity.VaccineDTO;

import java.util.List;

public interface VaccineService {
    Integer getVaccineSize();
    Page<Vaccine> getVaccines(Integer pageSize, Integer page);
    Vaccine getVaccine(Long id);
    Vaccine save(Vaccine vaccine);
    Page<Vaccine> getVaccines(String name, Pageable pageable);
}
