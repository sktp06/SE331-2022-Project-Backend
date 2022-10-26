package se331.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;

public interface DoctorDao {
    Integer getDoctorSize();
    Page<Doctor> getDoctors(Integer pageSize, Integer page);
    Doctor getDoctor(Long id);
    Doctor save(Doctor patient);
    Page<Doctor> getDoctors(String name, Pageable pageable);
}
