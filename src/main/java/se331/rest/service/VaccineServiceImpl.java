package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.dao.VaccineDao;
import se331.rest.entity.Vaccine;

@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    VaccineDao vaccineDao;

    @Override
    public Integer getVaccineSize() {
        return vaccineDao.getVaccineSize();
    }

    @Override
    public Page<Vaccine> getVaccines(Integer pageSize, Integer page) {
        return vaccineDao.getVaccines(pageSize, page);
    }

    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineDao.getVaccine(id);
    }

    @Override
    @Transactional
    public Vaccine save(Vaccine vaccine) {
        return vaccineDao.save(vaccine);
    }

    @Override
    public Page<Vaccine> getVaccines(String name, Pageable pageable) {
        return vaccineDao.getVaccines(name,pageable);
    }
}
