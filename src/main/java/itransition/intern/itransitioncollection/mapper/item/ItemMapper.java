package itransition.intern.itransitioncollection.mapper.item;

import itransition.intern.itransitioncollection.dtos.item.ItemCreateDto;
import itransition.intern.itransitioncollection.dtos.item.ItemDto;
import itransition.intern.itransitioncollection.dtos.item.ItemUpdateDto;
import itransition.intern.itransitioncollection.entity.item.Item;
import itransition.intern.itransitioncollection.mapper.base.BaseMapper;
import itransition.intern.itransitioncollection.mapper.base.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface ItemMapper extends GenericMapper<Item, ItemDto, ItemCreateDto, ItemUpdateDto>, BaseMapper {

    }
