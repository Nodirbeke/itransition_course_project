package itransition.intern.itransitioncollection.service.base;

import itransition.intern.itransitioncollection.mapper.base.BaseMapper;
import itransition.intern.itransitioncollection.repository.base.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<R extends BaseRepository, M extends BaseMapper> {

    protected final R repository;

    protected final M mapper;

}
