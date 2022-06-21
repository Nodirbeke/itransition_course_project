package itransition.intern.itransitioncollection.controller.auth;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserCreateDto;
import itransition.intern.itransitioncollection.dtos.auth.AuthUserUpdateDto;
import itransition.intern.itransitioncollection.service.authUser.AuthUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/auth")
public class AuthUserController extends AbstractController<AuthUserService> {

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @GetMapping("/create")
    public String createPage() {
        return "auth/register";
    }

    @PostMapping("/create")
    public String create(HttpServletRequest request, @ModelAttribute AuthUserCreateDto dto) {
        service.create(dto);
        return "redirect:" + request.getHeader("Referer");
    }

    @GetMapping({"/detail/{id}", "/get/{id}"})
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.get(id));
        return "user/detail";
    }

    @GetMapping({"/list", "/getAll"})
    public String getAll(Model model) {
        model.addAttribute("user", service.getAll());
        return "user/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("user", service.get(id));
        return "user/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute AuthUserUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(Model model, @PathVariable Long id) {
        model.addAttribute("user", service.get(id));
        return "user/delete";
    }

}
