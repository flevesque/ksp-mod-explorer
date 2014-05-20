package com.criticalweb.ksp.mod.explorer.controllers;

import com.criticalweb.ksp.mod.explorer.forms.Register;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Francois Levesque on 5/19/14.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("")
	public ModelAndView login() {
		return new ModelAndView("login/login");
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("login/register", "register", new Register());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute("register") Register register, BindingResult bindingResult) {
		LOG.info("result: " + bindingResult);
		ModelAndView mv = new ModelAndView("login/register", "register", register);
		return mv;
	}

}
