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
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Roman Gripskyi.
 * @since  3/9/2017.
 */
@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private static LinkedList<ArrayList<Boolean>> memoryLeak = new LinkedList<>();

    /**
     * fills all size of heap memory.
     */
    @RequestMapping(value = "/memory/fill", method = RequestMethod.POST)
    public String fillMemory() {

        logger.debug("inside fillMemory method");
        memoryLeak.add(new ArrayList<>(1024));
        logger.debug("user filled all  memory from heap");

        return "memory";
    }

    /**
     * just returns a 'welcome' page.
     * @return - view name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "welcome";
    }

    /**
     * throws new RuntimeException.
     */
    @RequestMapping(value = "/sendError", method = RequestMethod.GET)
    public String getError() {
        logger.debug("user press get error btn");
        throw new RuntimeException("'test exception'");
    }

    /**
     *  gets info about size of heap memory and send it into view.
     * @param model - model.
     * @return - view name with attributes with info about heap memory size.
     */
    @RequestMapping(value = "/memory", method = RequestMethod.GET)
    public String getMemoryInfo(Model model) {
        logger.debug("Inside getMemoryInfo");

        // Get current size of heap in bytes

        long heapSize = Runtime.getRuntime().totalMemory();
        logger.debug(" heap size is: {} ",heapSize);

        /* Get maximum size of heap in bytes. The heap cannot grow beyond this size.
         Any attempt will result in an OutOfMemoryException. */

        long heapMaxSize = Runtime.getRuntime().maxMemory();
        logger.debug(" heap max size is: {} ", heapMaxSize);

        /* Get amount of free memory within the heap in bytes. This size will increase
         after garbage collection and decrease as new objects are created.*/

        long heapFreeSize = Runtime.getRuntime().freeMemory();
        logger.debug(" heap free size is: {} ", heapFreeSize);

        model.addAttribute("heapSize", heapSize);
        model.addAttribute("heapMaxSize", heapMaxSize);
        model.addAttribute("heapFreeSize", heapFreeSize);
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