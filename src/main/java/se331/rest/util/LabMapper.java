package se331.rest.util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.rest.entity.*;
import se331.rest.security.entity.User;
import se331.rest.security.entity.UserDTO;

import java.util.List;
import java.util.stream.Collectors;
@Mapper(imports = Collectors.class)
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    PatientDTO getPatientDto(Patient patient);
    List<PatientDTO> getPatientDto(List<Patient> patients);
    DoctorDTO getDoctorDto(Doctor doctor);
    List<DoctorDTO> getDoctorDto(List<Doctor> doctors);

    CommentDTO getCommentDTO(Comment comment);
    List<CommentDTO> getCommentDTO(List<Comment> comments);
    List<VaccineDTO> getVaccineDTO(List<Vaccine> vaccines);
    VaccineDTO getVaccineDTO(Vaccine vaccine);


    @Mapping(target = "authorities", expression = "java(admin.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    AdminAuthDTO getAdminAuthDTO(Admin admin);

    @Mapping(target = "authorities", expression = "java(patient.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    PatientAuthDTO getPatientAuthDTO(Patient patient);

    @Mapping(target = "authorities", expression = "java(doctor.getUser().getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    DoctorAuthDTO getDoctorAuthDTO(Doctor doctor);

    UserDTO getUserDTO(User user);
    List<UserDTO>getUserDto(List<User> user);

    @Mapping(target = "authorities", expression = "java(user.getAuthorities().stream().map(auth -> auth.getName().name()).collect(Collectors.toList()))")
    UserAuthDTO getUserAuthDTO(User user);
}
