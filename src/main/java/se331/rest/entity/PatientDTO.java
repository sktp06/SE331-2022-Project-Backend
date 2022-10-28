package se331.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    Long id;
    String name;
    String surname;
    String age;
    String homeTown;
    String first_dose;
    String second_dose;
    String first_dose_date;
    String second_dose_date;
    List<String> imageUrls;

}
