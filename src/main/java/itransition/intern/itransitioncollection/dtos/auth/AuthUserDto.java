package itransition.intern.itransitioncollection.dtos.auth;

import itransition.intern.itransitioncollection.dtos.base.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthUserDto extends GenericDto {

    public AuthUserDto(Long id) {
        super(id);
    }

    private String username;

    private String email;

    private String fullName;

}
