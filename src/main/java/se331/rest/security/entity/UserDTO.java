package se331.rest.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.entity.AuthorityDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    String username;
    String email;
    String password;
    String age;
    String gender;
    String hometown;
    List<AuthorityDTO> authority;
    String image;

}