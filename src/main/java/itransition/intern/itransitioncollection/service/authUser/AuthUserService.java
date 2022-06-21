package itransition.intern.itransitioncollection.service.authUser;

import itransition.intern.itransitioncollection.dtos.auth.AuthUserCreateDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserUpdateDto;
import itransition.intern.itransitioncollection.mapper.auth.AuthUserMapper;
import itransition.intern.itransitioncollection.repository.auth.AuthUserRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper>
        implements GenericCrudService<AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto, Long>,
        UserDetailsService,
        BaseService {


    public AuthUserService(AuthUserRepository repository,
                           AuthUserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        return null;
    }

    @Override
    public Long update(AuthUserUpdateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        return null;
    }

    @Override
    public List<AuthUserDto> getAll() {
        return null;
    }
}
