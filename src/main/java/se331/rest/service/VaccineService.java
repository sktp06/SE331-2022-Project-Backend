package se331.rest.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.entity.VaccineDTO;

import java.util.List;

public interface VaccineService {
    Vaccine save(Vaccine vaccine);
    List<Vaccine> getAllVaccines();
    Vaccine getVaccine(Long id);

}
