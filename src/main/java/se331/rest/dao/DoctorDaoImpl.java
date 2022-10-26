package se331.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;

@Profile("db")
@Repository
public class DoctorDaoImpl implements DoctorDao{
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public Integer getDoctorSize() {
        return Math.toIntExact(doctorRepository.count());
    }
    @Override
    public Page<Doctor> getDoctors(Integer pageSize, Integer page) {
        return doctorRepository.findAll(PageRequest.of(page-1,pageSize));
    }
    @Override
    public Doctor getDoctor(Long id) {
        return doctorRepository.findById(id).orElse(null);
    }
    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    @Override
    public Page<Doctor> getDoctors(String name, Pageable pageable) {
        return doctorRepository.findByName(name, pageable);

    }
}
