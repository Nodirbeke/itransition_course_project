package itransition.intern.itransitioncollection.controller.collection;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.service.collection.CollectionService;

public class CollectionController extends AbstractController<CollectionService> {
    public CollectionController(CollectionService service) {
        super(service);
    }
}
