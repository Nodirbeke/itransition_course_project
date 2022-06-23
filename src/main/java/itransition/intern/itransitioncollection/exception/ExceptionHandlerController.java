package itransition.intern.itransitioncollection.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@ControllerAdvice("itransition.intern")
public class ExceptionHandlerController {

    @ExceptionHandler(value = NotFoundException.class)
    public String notFoundHandler() {
        return "error/404";
    }

    @ExceptionHandler(value = PermissionDeniedException.class)
    public String forbiddenHandler() {
        return "error/403";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/error");
        return mav;
    }

}
