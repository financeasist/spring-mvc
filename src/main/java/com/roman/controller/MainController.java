package com.roman.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = "/memory/fill", method = RequestMethod.POST)
    public String fillMemory(HttpServletRequest request,
                             HttpServletResponse response,
                             Model model) {

        return "memory";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(HttpServletRequest request,
                        HttpServletResponse responseModel, Model model) {

        return "welcome";
    }

    @RequestMapping(value = "/sendError") //, method = RequestMethod.GET)
    public String getError(Model model) {
        logger.debug("user press get error btn");
        throw new RuntimeException("'test exception'");
    }

    @RequestMapping(value = "/memory", method = RequestMethod.GET)
    public String memory(HttpServletRequest request,
                         HttpServletResponse response, Model model) {

        //TODO: return all memory of JVM(free/used) ;

        return "memory";
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex, Model model) {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", "Request: " + req.getRequestURL() + " raised " + ex);

        return modelAndView;
    }
}