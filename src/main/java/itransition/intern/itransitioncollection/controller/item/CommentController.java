package itransition.intern.itransitioncollection.controller.item;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.service.item.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/comment")
public class CommentController extends AbstractController<CommentService> {
    public CommentController(CommentService service) {
        super(service);
    }
}
