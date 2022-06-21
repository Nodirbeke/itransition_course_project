package itransition.intern.itransitioncollection.dtos.auth;

import itransition.intern.itransitioncollection.dtos.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserCreateDto implements BaseDto {

    private String username;

    private String email;

    private String password;

    private String confirmPassword;

}
