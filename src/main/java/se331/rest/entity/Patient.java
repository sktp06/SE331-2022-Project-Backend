package se331.rest.entity;

import lombok.*;
import se331.rest.security.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    String age;
    String homeTown;
    String first_dose;
    String second_dose;
    String first_dose_date;
    String second_dose_date;
//    String doctor_comment_patient;
    String image;
    @ElementCollection
    List<String> imageUrls;

    @OneToOne
    User user;

    @ManyToOne
    Doctor doctor;

    @OneToMany
    @Builder.Default
    List<Comment> commentList = new ArrayList<>();




}
