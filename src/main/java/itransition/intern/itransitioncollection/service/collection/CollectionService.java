package itransition.intern.itransitioncollection.service.collection;

import itransition.intern.itransitioncollection.configuration.SecurityAuditorAware;
import itransition.intern.itransitioncollection.dtos.collection.CollectionCreateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionUpdateDto;
import itransition.intern.itransitioncollection.entity.authUser.UserDetails;
import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.exception.NotFoundException;
import itransition.intern.itransitioncollection.exception.PermissionDeniedException;
import itransition.intern.itransitioncollection.mapper.collection.CollectionMapper;
import itransition.intern.itransitioncollection.repository.collection.CollectionRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CollectionService extends AbstractService<CollectionRepository, CollectionMapper>
        implements GenericCrudService<CollectionDto, CollectionCreateDto, CollectionUpdateDto, Long>, BaseService {

    private final SecurityAuditorAware securityAuditorAware;

    public CollectionService(CollectionRepository repository,
                             CollectionMapper mapper,
                             SecurityAuditorAware securityAuditorAware) {
        super(repository, mapper);
        this.securityAuditorAware = securityAuditorAware;
    }

    @Override
    public Long create(CollectionCreateDto createDto) {
        Collection collection = mapper.fromCreatDto(createDto);
        Collection save = repository.save(collection);
        return save.getId();
    }

    @Override
    public CollectionDto get(Long id) {
        return mapper.toDto(getCollectionByIdAndCheckExistence(id));
    }

    @Override
    public List<CollectionDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public Long update(CollectionUpdateDto updateDto) {
        Collection collection = mapper.fromUpdateDto(updateDto);
        Collection save = repository.save(collection);
        return save.getId();

    }

    @Override
    public Void delete(Long id) throws PermissionDeniedException {
        Collection collection = getCollectionByIdAndCheckExistence(id);
        checkOwnership(collection);
        repository.softDeleteById(id);
        return null;
    }

    private void checkOwnership(Collection collection) throws PermissionDeniedException {
        if (!Objects.equals(securityAuditorAware.getCurrentAuditor().get(), collection.getAuthUser().getId())
                || securityAuditorAware.getCurrentAuditor().isEmpty()) {
            throw new PermissionDeniedException("PERMISSION_DENIED");
        }
    }

    private Collection getCollectionByIdAndCheckExistence(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("COLLECTION_NOT_FOUND"));
    }

}
