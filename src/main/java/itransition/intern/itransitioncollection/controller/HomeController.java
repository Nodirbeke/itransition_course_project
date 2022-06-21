package itransition.intern.itransitioncollection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping({"/", "/home", ""})
    public String homePage() {
        return "index";
    }


    @PostMapping({"/back"})
    public String homePage(HttpServletRequest request) {
        return "redirect:" + request.getHeader("Referer");
    }

}
