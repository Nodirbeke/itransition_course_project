package itransition.intern.itransitioncollection.mapper.collection;

import itransition.intern.itransitioncollection.dtos.collection.CollectionUpdateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionCreateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionDto;
import itransition.intern.itransitioncollection.entity.collection.Collection;
import itransition.intern.itransitioncollection.mapper.base.BaseMapper;
import itransition.intern.itransitioncollection.mapper.base.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CollectionMapper extends GenericMapper<Collection, CollectionDto, CollectionCreateDto, CollectionUpdateDto>, BaseMapper {

}
