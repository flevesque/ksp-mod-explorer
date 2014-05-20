package com.criticalweb.ksp.mod.explorer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Controller
public class DefaultController {

    @RequestMapping("")
    public ModelAndView main() {
        return new ModelAndView("main");
    }

}
