package itransition.intern.itransitioncollection.controller.exceptionHandeler;

import itransition.intern.itransitioncollection.exception.NotFoundException;
import itransition.intern.itransitioncollection.exception.PermissionDeniedException;
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
    public ModelAndView notFoundHandler(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/error");
        return mav;
    }

    @ExceptionHandler(value = PermissionDeniedException.class)
    public ModelAndView forbiddenHandler(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error/error");
        return mav;
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
