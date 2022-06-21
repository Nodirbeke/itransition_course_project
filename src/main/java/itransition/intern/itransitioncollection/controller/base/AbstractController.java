package itransition.intern.itransitioncollection.controller.base;

import itransition.intern.itransitioncollection.service.base.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> {

    protected final S service;

}
