package itransition.intern.itransitioncollection.service.base;

import itransition.intern.itransitioncollection.dtos.base.BaseDto;
import itransition.intern.itransitioncollection.dtos.base.GenericDto;

import java.io.Serializable;
import java.util.List;

/**
 * \
 *
 * @param <D> -> DTO
 * @param <K> -> Key
 */
public interface GenericService<D extends GenericDto,
        K extends Serializable> extends BaseService {

    public D get(K id);

    public List<D> getAll();

    public List<D> getAll(K id);


}
