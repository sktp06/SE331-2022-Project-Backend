package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.dao.DoctorDao;
import se331.rest.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorDao doctorDao;

    @Override
    public Integer getDoctorSize() {
        return doctorDao.getDoctorSize();
    }

    @Override
    public Page<Doctor> getDoctors(Integer pageSize, Integer page) {
        return doctorDao.getDoctors(pageSize, page);
    }

    @Override
    public Doctor getDoctor(Long id) {
        return doctorDao.getDoctor(id);
    }

    @Override
    @Transactional
    public Doctor save(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    @Override
    public Page<Doctor> getDoctors(String name, Pageable pageable) {
        return doctorDao.getDoctors(name,pageable);
    }
}
