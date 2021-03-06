package itransition.intern.itransitioncollection.controller.auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "auth/logout";
    }

    @GetMapping("/register")
    public String registrationPage() {
        return "user/register";
    }

}
