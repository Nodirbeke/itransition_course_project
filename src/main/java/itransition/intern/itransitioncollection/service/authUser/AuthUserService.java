package itransition.intern.itransitioncollection.service.authUser;

import itransition.intern.itransitioncollection.dtos.auth.AuthUserCreateDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserUpdateDto;
import itransition.intern.itransitioncollection.entity.authUser.AuthUser;
import itransition.intern.itransitioncollection.exception.NotFoundException;
import itransition.intern.itransitioncollection.mapper.auth.AuthUserMapper;
import itransition.intern.itransitioncollection.repository.auth.AuthUserRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import itransition.intern.itransitioncollection.entity.authUser.UserDetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthUserService extends AbstractService<AuthUserRepository, AuthUserMapper>
        implements GenericCrudService<AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto, Long>,
        UserDetailsService,
        BaseService {

    private final PasswordEncoder encoder;

    public AuthUserService(AuthUserRepository repository,
                           AuthUserMapper mapper,
                           PasswordEncoder encoder) {
        super(repository, mapper);
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String domain) {
        AuthUser authUser = repository.findByUsernameOrEmail(domain)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
        return new UserDetails(authUser);
    }


    @Override
    public Long create(AuthUserCreateDto createDto) {
        checkPassword(createDto.getPassword(), createDto.getConfirmPassword());
        AuthUser authUser = mapper.fromCreatDto(createDto);
        authUser.setPassword(encoder.encode(authUser.getPassword()));
        AuthUser save = repository.save(authUser);
        return save.getId();
    }

    @Override
    public Long update(AuthUserUpdateDto updateDto) {
        getAuthUserByIdAndCheckExistence(updateDto.getId());
        AuthUser authUser = mapper.fromUpdateDto(updateDto);
        repository.save(authUser);
        return authUser.getId();
    }

    @Override
    public Void delete(Long id) {
        UUID uuid = UUID.randomUUID();
        repository.softDeleteById(id, uuid);
        return null;
    }

    @Override
    public AuthUserDto get(Long id) {
        AuthUser authUser = getAuthUserByIdAndCheckExistence(id);
        return mapper.toDto(authUser);
    }

    @Override
    public List<AuthUserDto> getAll() {
        return mapper.toDto(repository.findAll());
    }


    public void blockOrUnblock(Long id) {
        AuthUser authUser = getAuthUserByIdAndCheckExistence(id);
        authUser.setBlocked(authUser.getBlocked() ? Boolean.TRUE : Boolean.FALSE);
        repository.save(authUser);
    }

    private AuthUser getAuthUserByIdAndCheckExistence(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("USER_NOT_FOUND"));
    }

    public void blockOrUnblock(List<Long> ids) {
        for (Long id : ids) {
            getAuthUserByIdAndCheckExistence(id);
            blockOrUnblock(id);
        }
    }

    public void delete(List<Long> ids) {
        for (Long id : ids) {
            getAuthUserByIdAndCheckExistence(id);
            delete(id);
        }
    }

    private void checkPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) throw new RuntimeException("PASSWORD_NOT_MATCHES");
    }


}
