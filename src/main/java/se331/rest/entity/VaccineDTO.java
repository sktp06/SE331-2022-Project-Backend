package se331.rest.entity;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VaccineDTO {
    Long id;
    String name;
    List<PatientDTO> patientList;


}
