package se331.rest.entity;

import lombok.*;
import se331.rest.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;

    @OneToOne
    User user;

    @OneToMany
    @Builder.Default
    List<Patient> patientList = new ArrayList<>();


    @OneToMany(mappedBy = "doctor")
    @Builder.Default
    List<Patient> peopleList = new ArrayList<>();
}
