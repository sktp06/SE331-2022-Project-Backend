package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Patient tempEvent = null;
        Vaccine vaccine = null;
        tempEvent = patientRepository.save(Patient.builder()
                .name("Marwa")
                .surname("Giles")
                .age("18")
                .homeTown("Mount Stone")
                .build());
        vaccine = vaccineRepository.save(Vaccine.builder()
                .name("Pfizer")
                .build());
        vaccine.setPatient(tempEvent);
        tempEvent.getVaccineList().add(vaccine);
        vaccine = vaccineRepository.save(Vaccine.builder()
                .name("Pfizer")
                .build());
        vaccine.setPatient(tempEvent);
        tempEvent.getVaccineList().add(vaccine);

        tempEvent = patientRepository.save(Patient.builder()
                .name("Ameen")
                .surname("Quintana")
                .age("20")
                .homeTown("St Stour")
                .build());
        vaccine = vaccineRepository.save(Vaccine.builder()
                .name("Modena")
                .build());
        vaccine.setPatient(tempEvent);
        tempEvent.getVaccineList().add(vaccine);
        vaccine = vaccineRepository.save(Vaccine.builder()
                .name("Pfizer")
                .build());
        vaccine.setPatient(tempEvent);
        tempEvent.getVaccineList().add(vaccine);



    }


}
