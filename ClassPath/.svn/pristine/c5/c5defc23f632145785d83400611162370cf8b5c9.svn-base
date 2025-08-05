package kr.or.ddit.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            switch (statusCode) {
                case 400: return "redirect:/error/400.html";
                case 401: return "redirect:/error/401.html";
                case 403: return "redirect:/error/403.html";
                case 404: return "redirect:/error/404.html";
                default: return "redirect:/error/666.html";
            }
        }

        return "redirect:/";
    }
}