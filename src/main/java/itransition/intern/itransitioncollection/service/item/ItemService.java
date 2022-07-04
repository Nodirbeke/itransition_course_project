package itransition.intern.itransitioncollection.service.item;

import itransition.intern.itransitioncollection.dtos.item.ItemCreateDto;
import itransition.intern.itransitioncollection.dtos.item.ItemDto;
import itransition.intern.itransitioncollection.dtos.item.ItemUpdateDto;
import itransition.intern.itransitioncollection.entity.item.Item;
import itransition.intern.itransitioncollection.exception.NotFoundException;
import itransition.intern.itransitioncollection.mapper.item.ItemMapper;
import itransition.intern.itransitioncollection.repository.item.ItemRepository;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.base.BaseService;
import itransition.intern.itransitioncollection.service.base.GenericCrudService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ItemService extends AbstractService<ItemRepository, ItemMapper>
        implements GenericCrudService<ItemDto, ItemCreateDto, ItemUpdateDto, Long>, BaseService {
    public ItemService(ItemRepository repository,
                       ItemMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public Long create(ItemCreateDto createDto) {
        Item item = mapper.fromCreatDto(createDto);
        Item save = repository.save(item);
        return save.getId();
    }

    @Override
    public Long update(ItemUpdateDto updateDto) {
        Item targetItem = getItemById(updateDto.getId());
        mapper.fromUpdateDto(updateDto, targetItem);
        return null;
    }

    private Item getItemById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ITEM_NOT_FOUND"));
    }

    @Override
    public Void delete(Long id) {

        
        return null;
    }

    @Override
    public ItemDto get(Long id) {
        return mapper.toDto(getItemById(id));
    }

    @Override
    public List<ItemDto> getAll() {
        return null;
    }

    @Override
    public List<ItemDto> getAll(Long id) {
        return null;
    }

}
