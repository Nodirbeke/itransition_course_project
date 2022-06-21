package itransition.intern.itransitioncollection.mapper.base;

import itransition.intern.itransitioncollection.dtos.base.BaseDto;
import itransition.intern.itransitioncollection.dtos.base.GenericDto;
import itransition.intern.itransitioncollection.entity.base.BaseEntity;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto> {

    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E fromCreatDto(CD createDto);

    E fromUpdateDto(UD updateDto, @MappingTarget E entity);

}
