package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.dao.PatientDao;
import se331.rest.entity.Comment;
import se331.rest.entity.Patient;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientDao patientDao;

    @Override
    public Integer getPatientSize() {
        return patientDao.getPatientSize();
    }

    @Override
    public Page<Patient> getPatients(Integer pageSize, Integer page) {
        return patientDao.getPatients(pageSize, page);
    }

    @Override
    public Patient getPatient(Long id) {
        return patientDao.getPatient(id);
    }

    @Override
    @Transactional
    public Patient save(Patient patient) {
        return patientDao.save(patient);
    }

    @Override
    public Page<Patient> getPatients(String name, Pageable pageable) {
        return patientDao.getPatients(name,pageable);
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientDao.getPatient(Pageable.unpaged()).getContent();
    }
}
