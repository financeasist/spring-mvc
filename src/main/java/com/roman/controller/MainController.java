package com.roman.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {


    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
    public ModelAndView handleRequestInternal(HttpServletRequest request,
                                              HttpServletResponse response) {

        return new ModelAndView("welcome");
        //TODO : return json or text/html - depend on headers:content-type

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {
        //TODO: return all memory of JVM(free/used) ;
        throw new RuntimeException();
//        return "welcome";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
//        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        //TODO: responce - 500;
        //TODO: responce - json: 'error'='500';
        return new ModelAndView("error");
    }
}