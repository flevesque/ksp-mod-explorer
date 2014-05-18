package com.criticalweb.ksp.mod.explorer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rezz on 5/18/14.
 */
@Controller
public class DefaultController {

    @RequestMapping("")
    public ModelAndView main() {
        return new ModelAndView("main");
    }

}
