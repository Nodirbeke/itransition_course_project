package itransition.intern.itransitioncollection.controller.item;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentCreateDto;
import itransition.intern.itransitioncollection.dtos.item.comment.CommentUpdateDto;
import itransition.intern.itransitioncollection.service.item.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/comment")
public class CommentController extends AbstractController<CommentService> {
    public CommentController(CommentService service) {
        super(service);
    }


    @PostMapping("/create")
    public Long create(@RequestBody CommentCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping({"/detail/{id}", "/get/{id}"})
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("comment", service.get(id));
        return "comment/detail";
    }

    @GetMapping({"/list/{itemId}", "/getAll/{itemId}"})
    public String getAll(@PathVariable Long itemId, Model model) {
        model.addAttribute("comment", service.getAll(itemId));
        return "comment/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute CommentUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Long id, HttpServletRequest request) {
        service.delete(id);
        return "redirect:" + request.getHeader("Referer");
    }

}
