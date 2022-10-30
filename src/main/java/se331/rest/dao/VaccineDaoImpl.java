package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Comment;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.VaccineRepository;

@Profile("db")
@Repository
public class VaccineDaoImpl implements VaccineDao {
    @Autowired
    VaccineRepository vaccineRepository;
    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }
    @Override
    public Page<Vaccine> getVaccine(Pageable pageRequest) {
        return vaccineRepository.findAll(pageRequest);
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }
}
