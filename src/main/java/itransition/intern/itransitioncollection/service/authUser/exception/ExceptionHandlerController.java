package itransition.intern.itransitioncollection.service.authUser.exception;

import itransition.intern.itransitioncollection.exception.NotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(NotFoundException.class)
    public String notFoundHandler() {
        return "error/404";
    }

    ;

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

}
