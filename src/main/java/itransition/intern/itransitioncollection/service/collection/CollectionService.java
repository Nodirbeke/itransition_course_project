package itransition.intern.itransitioncollection.service.collection;

import itransition.intern.itransitioncollection.dtos.collection.CollectionCreateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionUpdateDto;
import itransition.intern.itransitioncollection.mapper.collection.CollectionMapper;
import itransition.intern.itransitioncollection.repository.collection.CollectionRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService extends AbstractService<CollectionRepository, CollectionMapper>
        implements GenericCrudService<CollectionDto, CollectionCreateDto, CollectionUpdateDto, Long>, BaseService {
    public CollectionService(CollectionRepository repository, CollectionMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(CollectionCreateDto createDto) {
        return null;
    }

    @Override
    public Long update(CollectionUpdateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public CollectionDto get(Long id) {
        return null;
    }

    @Override
    public List<CollectionDto> getAll() {
        return null;
    }
}
