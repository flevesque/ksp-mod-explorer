package com.criticalweb.ksp.mod.explorer.controllers;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.exceptions.ExpandedEntityExistsException;
import com.criticalweb.ksp.mod.explorer.forms.Register;
import com.criticalweb.ksp.mod.explorer.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Resource
	UserService userService;

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

		if (bindingResult.getFieldErrors().size() > 0) {
			return new ModelAndView("login/register", "register", register);
		}

		try {
			User user = userService.createNewUser(register.getUsername(), register.getPassword(), register.getEmail(), register.getDisplayname());

			ModelAndView mv = new ModelAndView("redirect:/login/registration-complete");
			mv.addObject("id", user.getId());

			return mv;

		} catch (ExpandedEntityExistsException e) {

			for (String field : e.getFields()) {
				bindingResult.rejectValue(field, String.format("form.register.fields.%s.exists", field));
			}

			return new ModelAndView("login/register", "register", register);

		}

	}

	@RequestMapping(value="/registration-complete")
	public ModelAndView registrationComplete(@RequestParam(value = "id", required = true) String id) {

		User user = userService.getUserById(Long.valueOf(id));

		ModelAndView mv = new ModelAndView("login/registrationComplete");
		mv.addObject("user", user);

		return mv;
	}

}
