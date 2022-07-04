package itransition.intern.itransitioncollection.controller.collection;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserCreateDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserUpdateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionCreateDto;
import itransition.intern.itransitioncollection.dtos.collection.CollectionUpdateDto;
import itransition.intern.itransitioncollection.service.collection.CollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Lob;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/collection")
public class CollectionController extends AbstractController<CollectionService> {
    public CollectionController(CollectionService service) {
        super(service);
    }

    @GetMapping({"/create"})
    public String createPage() {
        return "collection/create";
    }

    @PostMapping({"/create"})
    public String create(@ModelAttribute CollectionCreateDto dto) {
        service.create(dto);
        return "redirect:collection/list";
    }

    @GetMapping({"/detail/{id}", "/get/{id}"})
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("collection", service.get(id));
        return "collection/detail";
    }

    @GetMapping({"/list/{userId}", "/getAll/{userId}"})
    public String getAll(@PathVariable Long userId, Model model) {
        model.addAttribute("collection", service.getAll(userId));
        return "collection/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("collection", service.get(id));
        return "collection/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CollectionUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(Model model, @PathVariable Long id) {
        model.addAttribute("collection", service.get(id));
        return "collection/delete";
    }
}
