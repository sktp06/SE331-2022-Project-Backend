package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    DoctorRepository doctorRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Doctor doc1, doc2;
        doc1 = doctorRepository.save(Doctor.builder()
                .name("Isabelle")
                .surname("Mayo")
                .build());
        doc2 = doctorRepository.save(Doctor.builder()
                .name("Harun")
                .surname("Derrick")
                .build());

        Vaccine vac1, vac2, vac3;
        vac1 = vaccineRepository.save(Vaccine.builder()
                .name("Pfizer")
                .build());
        vac2 = vaccineRepository.save(Vaccine.builder()
                .name("AstraZeneca")
                .build());
        vac3 = vaccineRepository.save(Vaccine.builder()
                .name("Moderna")
                .build());

        Patient pat1, pat2, pat3, pat4, pat5, pat6;
        pat1 = patientRepository.save(Patient.builder()
                .name("Marwa")
                .surname("Giles")
                .age("18")
                .homeTown("Mount Stone")
                .first_dose_date("Jun 14, 2022")
                .second_dose_date("Sep 20, 2022")
                .build());
        vac1.getPatientList().add(pat1);
        vac1.getPatientList().add(pat1);
        doc1.getPatientList().add(pat1);

        pat2 = patientRepository.save(Patient.builder()
                .name("Ameen")
                .surname("Quintana")
                .age("20")
                .homeTown("St Stour")
                .first_dose_date("Jan 30, 2022")
                .build());
        vac3.getPatientList().add(pat2);
        doc1.getPatientList().add(pat2);

        pat3 = patientRepository.save(Patient.builder()
                .name("Chardonnay")
                .surname("Dixon")
                .age("23")
                .homeTown("Unmoglos")
                .first_dose_date("Apr 05, 2022")
                .second_dose_date("July 12, 2022")
                .build());
        vac2.getPatientList().add(pat3);
        vac2.getPatientList().add(pat3);
        doc1.getPatientList().add(pat3);

        pat4 = patientRepository.save(Patient.builder()
                .name("Owais")
                .surname("Howe")
                .age("21")
                .homeTown("East Masbeau")
                .first_dose_date("Feb 19, 2022")
                .second_dose_date("Jun 25, 2022")
                .build());
        vac1.getPatientList().add(pat4);
        vac2.getPatientList().add(pat4);
        doc2.getPatientList().add(pat4);


        pat5 = patientRepository.save(Patient.builder()
                .name("Noa")
                .surname("Carroll")
                .age("18")
                .homeTown("Port Tiermurgu")
                .first_dose_date("Jan 24, 2022")
                .second_dose_date("April 19, 2022")
                .build());
        vac1.getPatientList().add(pat5);
        vac3.getPatientList().add(pat5);
        doc2.getPatientList().add(pat5);


        pat6 = patientRepository.save(Patient.builder()
                .name("Kayden")
                .surname("Vaughn")
                .age("23")
                .homeTown("Kalbci Colonies")
                .first_dose_date("Jan 02, 2022")
                .build());
        vac2.getPatientList().add(pat6);
        doc2.getPatientList().add(pat6);





    }


}
