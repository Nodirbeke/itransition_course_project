package itransition.intern.itransitioncollection.dtos.auth;

import itransition.intern.itransitioncollection.dtos.base.GenericDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserUpdateDto extends GenericDto {
    public AuthUserUpdateDto(Long id) {
        super(id);
    }

    private String username;
    private String fullName;
    private String email;

}
