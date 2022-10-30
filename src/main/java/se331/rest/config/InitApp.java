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
                .name("Kylie")
                .surname("Jenner")
                .age("18")
                .homeTown("Mount Stone")
                .first_dose("Pfizer")
                .second_dose("Pfizer")
                .first_dose_date("Jun 14, 2022")
                .second_dose_date("Sep 20, 2022")
                .doctor_comment_patient("Drink more water")
                .image("https://p16-sign-va.tiktokcdn.com/tos-maliva-avt-0068/9291601308707957042cdedd2b77a85e~c5_720x720.jpeg?x-expires=1667156400&x-signature=67VSV8PrBsl7QI3oNFruTKHmxyk%3D")
                .build());
        vac1.getPatientList().add(pat1);
        vac1.getPatientList().add(pat1);
        doc1.getPatientList().add(pat1);

        pat2 = patientRepository.save(Patient.builder()
                .name("Travis")
                .surname("Scott")
                .age("20")
                .homeTown("St Stour")
                .first_dose("AstraZeneca")
                .first_dose_date("Jan 30, 2022")
                .doctor_comment_patient("Stop smoking")
                        .image("https://media.gq.com/photos/5f356039092046da7abdb510/master/w_2000,h_3000,c_limit/travis-scott-gq-cover-september-2020-04.jpg")
                .build());
        vac3.getPatientList().add(pat2);
        doc1.getPatientList().add(pat2);

        pat3 = patientRepository.save(Patient.builder()
                .name("Kendall")
                .surname("Jenner")
                .age("23")
                .homeTown("Unmoglos")
                .first_dose("Moderna")
                .second_dose("Moderna")
                .first_dose_date("Apr 05, 2022")
                .second_dose_date("July 12, 2022")
                .doctor_comment_patient("Eat a balanced diet")
                .image("https://media.allure.com/photos/621e32e93c1316abf45cb59b/2:3/w_1940,h_2910,c_limit/kendall%20jenner%20.jpg")
                .build());
        vac2.getPatientList().add(pat3);
        vac2.getPatientList().add(pat3);
        doc1.getPatientList().add(pat3);

        pat4 = patientRepository.save(Patient.builder()
                .name("Bella")
                .surname("Hadid")
                .age("21")
                .homeTown("East Masbeau")
                .first_dose("Pfizer")
                .second_dose("Pfizer")
                .first_dose_date("Feb 19, 2022")
                .second_dose_date("Jun 25, 2022")
                .doctor_comment_patient("Maintain a healthy weight")
                .image("https://media.vanityfair.com/photos/61f81ae4d25c05ade4095a79/1:1/w_2761,h_2761,c_limit/1200014422")
                .build());
        vac1.getPatientList().add(pat4);
        vac2.getPatientList().add(pat4);
        doc2.getPatientList().add(pat4);


        pat5 = patientRepository.save(Patient.builder()
                .name("Conan")
                .surname("Gray")
                .age("18")
                .homeTown("Port Tiermurgu")
                .first_dose("Pfizer")
                .second_dose("Moderna")
                .first_dose_date("Jan 24, 2022")
                .second_dose_date("April 19, 2022")
                .doctor_comment_patient("Prioritise sleep")
                .image("https://i.scdn.co/image/ab6761610000e5ebd3a1193ab04e0fb2b297e619")
                .build());
        vac1.getPatientList().add(pat5);
        vac3.getPatientList().add(pat5);
        doc2.getPatientList().add(pat5);


        pat6 = patientRepository.save(Patient.builder()
                .name("Olivia")
                .surname("Rodrigo")
                .age("18")
                .homeTown("Kalbci Colonies")
                .first_dose("Moderna")
                .first_dose_date("Jan 02, 2022")
                .doctor_comment_patient("Exercise more")
                .image("https://media.glamour.com/photos/60afe10e10793d699b3144cd/6:7/w_2568,h_2996,c_limit/SOUR_FINAL.jpg")
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
