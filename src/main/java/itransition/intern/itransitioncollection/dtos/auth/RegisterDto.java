package itransition.intern.itransitioncollection.dtos.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

    private String username;

    private String email;

    private String password;

    private String confirmPassword;

}
