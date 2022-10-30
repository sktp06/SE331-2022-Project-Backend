package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Patient;

import java.util.List;

public interface PatientService {
    Integer getPatientSize();
    Page<Patient> getPatients(Integer pageSize, Integer page);
    Patient getPatient(Long id);
    Patient save(Patient patient);
    Page<Patient> getPatients(String name, Pageable pageable);

    List<Patient> getAllPatients();
}
