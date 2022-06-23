package itransition.intern.itransitioncollection.service.base;

import itransition.intern.itransitioncollection.dtos.base.BaseDto;
import itransition.intern.itransitioncollection.dtos.base.GenericDto;
import itransition.intern.itransitioncollection.exception.PermissionDeniedException;

import java.io.Serializable;

/**
 * @param <D>  -> DTO
 * @param <CD> -> Create DTO
 * @param <UD> -> Update DTO
 * @param <K>  -> Key
 */
public interface GenericCrudService<D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto,
        K extends Serializable>
        extends GenericService<D, K> {


    public K create(CD createDto);

    public K update(UD updateDto);

    public Void delete(K id) throws PermissionDeniedException;


}
