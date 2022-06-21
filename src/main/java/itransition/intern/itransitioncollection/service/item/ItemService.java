package itransition.intern.itransitioncollection.service.item;

import itransition.intern.itransitioncollection.dtos.item.ItemCreateDto;
import itransition.intern.itransitioncollection.dtos.item.ItemDto;
import itransition.intern.itransitioncollection.dtos.item.ItemUpdateDto;
import itransition.intern.itransitioncollection.mapper.item.ItemMapper;
import itransition.intern.itransitioncollection.repository.item.ItemRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService extends AbstractService<ItemRepository, ItemMapper>
        implements GenericCrudService<ItemDto, ItemCreateDto, ItemUpdateDto, Long>, BaseService {
    public ItemService(ItemRepository repository, ItemMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(ItemCreateDto createDto) {
        return null;
    }

    @Override
    public Long update(ItemUpdateDto createDto) {
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public ItemDto get(Long id) {
        return null;
    }

    @Override
    public List<ItemDto> getAll() {
        return null;
    }
}
