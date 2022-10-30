package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;

public interface VaccineDao {
    Vaccine save (Vaccine vaccine);
    Page<Vaccine> getVaccine(Pageable pageRequest);
    Vaccine getVaccine(Long id);



}
