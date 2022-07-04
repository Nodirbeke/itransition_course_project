package itransition.intern.itransitioncollection.service.collection;

import itransition.intern.itransitioncollection.configuration.SecurityAuditorAware;
import itransition.intern.itransitioncollection.dtos.collection.CollectionCreateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionUpdateDto;
import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.enums.AuthRole;
import itransition.intern.itransitioncollection.exception.NotFoundException;
import itransition.intern.itransitioncollection.exception.PermissionDeniedException;
import itransition.intern.itransitioncollection.mapper.collection.CollectionMapper;
import itransition.intern.itransitioncollection.repository.collection.CollectionRepository;
import itransition.intern.itransitioncollection.service.authUser.AuthUserService;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class CollectionService extends AbstractService<CollectionRepository, CollectionMapper>
        implements GenericCrudService<CollectionDto, CollectionCreateDto, CollectionUpdateDto, Long>, BaseService {

    private final SecurityAuditorAware securityAuditorAware;
    private final AuthUserService authUserService;

    public CollectionService(CollectionRepository repository,
                             CollectionMapper mapper,
                             SecurityAuditorAware securityAuditorAware,
                             AuthUserService authUserService) {
        super(repository, mapper);
        this.securityAuditorAware = securityAuditorAware;
        this.authUserService = authUserService;
    }

    @Override
    public Long create(CollectionCreateDto createDto) {
        Collection collection = mapper.fromCreatDto(createDto);
        Collection save = repository.save(collection);
        return save.getId();
    }

    @Override
    public CollectionDto get(Long id) {
        checkExistence(id);
        return mapper.toDto(getCollectionById(id));
    }

    @Override
    public List<CollectionDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public List<CollectionDto> getAll(Long id) {
        authUserService.checkExistence(id);
        List<Collection> collections = repository.findCollectionByAuthUser(id);
        return mapper.toDto(collections);
    }

    @Override
    public Long update(CollectionUpdateDto updateDto) {
        Collection target = getCollectionById(updateDto.getId());
        checkPermission(target);
        Collection collection = mapper.fromUpdateDto(updateDto, target);
        Collection save = repository.save(collection);
        return save.getId();

    }

    @Override
    public Void delete(Long id) {
        Collection collection = getCollectionById(id);
        checkPermission(collection);
        UUID uuid = UUID.randomUUID();
        repository.softDeleteById(id, uuid);
        return null;
    }

    private Collection getCollectionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("COLLECTION_NOT_FOUND"));
    }

    private void checkPermission(Collection collection) {
        Optional<Long> currentAuditor = securityAuditorAware.getCurrentAuditor();
        if (securityAuditorAware.getCurrentAuditor().isEmpty()
                || !Objects.equals(currentAuditor.get(), collection.getAuthUser().getId())
                || !authUserService.getAuthUserById(currentAuditor.get()).getRole().equals(AuthRole.ADMIN)) {
            throw new PermissionDeniedException("PERMISSION_DENIED");
        }
    }

    private void checkExistence(Long id) {
        if (repository.existsById(id)) {
            throw new NotFoundException("COLLECTION_NOT_FOUND");
        }
    }

}
