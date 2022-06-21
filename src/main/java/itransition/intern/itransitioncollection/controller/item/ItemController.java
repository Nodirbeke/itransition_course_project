package itransition.intern.itransitioncollection.controller.item;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.service.base.AbstractService;
import itransition.intern.itransitioncollection.service.item.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/item")
public class ItemController extends AbstractController<ItemService> {
    public ItemController(ItemService service) {
        super(service);
    }
}
