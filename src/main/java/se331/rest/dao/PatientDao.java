package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Comment;
import se331.rest.entity.Patient;

public interface PatientDao {
    Integer getPatientSize();
    Page<Patient> getPatients(Integer pageSize, Integer page);
    Patient getPatient(Long id);
    Patient save(Patient patient);
    Page<Patient> getPatients(String name, Pageable pageable);
    Page<Patient> getPatient(Pageable pageRequest);
}
