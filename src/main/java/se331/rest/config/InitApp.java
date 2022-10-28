package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.entity.Doctor;
import se331.rest.entity.Patient;
import se331.rest.entity.Vaccine;
import se331.rest.repository.DoctorRepository;
import se331.rest.repository.PatientRepository;
import se331.rest.repository.VaccineRepository;
import se331.rest.security.entity.Authority;
import se331.rest.security.entity.AuthorityName;
import se331.rest.security.entity.User;
import se331.rest.security.repository.AuthorityRepository;
import se331.rest.security.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    VaccineRepository vaccineRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserRepository userRepository;


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
                .first_dose("Pfizer")
                .second_dose("Pfizer")
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
                .first_dose("AstraZeneca")
                .first_dose_date("Jan 30, 2022")
                .build());
        vac3.getPatientList().add(pat2);
        doc1.getPatientList().add(pat2);

        pat3 = patientRepository.save(Patient.builder()
                .name("Chardonnay")
                .surname("Dixon")
                .age("23")
                .homeTown("Unmoglos")
                .first_dose("Moderna")
                .second_dose("Moderna")
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
                .first_dose("Pfizer")
                .second_dose("Pfizer")
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
                .first_dose("Pfizer")
                .second_dose("Moderna")
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
                .first_dose("Moderna")
                .first_dose_date("Jan 02, 2022")
                .build());
        vac2.getPatientList().add(pat6);
        doc2.getPatientList().add(pat6);
        addUser();

        doc1.setUser(user1);
        user1.setDoctor(doc1);
        pat1.setUser(user2);
        user2.setPatient(pat1);
        pat2.setUser(user2);
        user2.setPatient(pat2);
        pat3.setUser(user2);
        user2.setPatient(pat3);
        pat4.setUser(user2);
        user2.setPatient(pat4);
        pat5.setUser(user2);
        user2.setPatient(pat5);
        pat6.setUser(user2);
        user2.setPatient(pat6);
        doc2.setUser(user3);
        user3.setDoctor(doc2);

    }
    User user1,user2,user3,user4;
    private  void addUser(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority authAdmin = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        Authority authDoctor = Authority.builder().name(AuthorityName.ROLE_DOCTOR).build();

        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user3 = User.builder()
                .username("doctor")
                .password(encoder.encode("doctor"))
                .firstname("doctor")
                .lastname("doctor")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user4 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021,01,01)
                        .atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        authorityRepository.save(authUser);
        authorityRepository.save(authAdmin);
        authorityRepository.save(authDoctor);

        user1.getAuthorities().add(authUser);
        user1.getAuthorities().add(authAdmin);
        user2.getAuthorities().add(authUser);
        user3.getAuthorities().add(authDoctor);
        user4.getAuthorities().add(authUser);

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);

    }


}
