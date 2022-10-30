package se331.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.dao.CommentDao;
import se331.rest.dao.VaccineDao;
import se331.rest.entity.Comment;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;

import java.util.List;

@Service
public class VaccineServiceImpl implements VaccineService {
    @Autowired
    VaccineDao vaccineDao;

    @Override
    public Vaccine save(Vaccine vaccine) {
        return vaccineDao.save(vaccine);
    }

    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineDao.getVaccine(Pageable.unpaged()).getContent();
    }
    @Override
    public Vaccine getVaccine(Long id) {
        return vaccineDao.getVaccine(id);
    }
}
