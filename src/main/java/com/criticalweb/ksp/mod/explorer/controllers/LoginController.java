package com.criticalweb.ksp.mod.explorer.controllers;

import com.criticalweb.ksp.mod.explorer.entities.User;
import com.criticalweb.ksp.mod.explorer.exceptions.ExpandedEntityExistsException;
import com.criticalweb.ksp.mod.explorer.exceptions.InvalidActivationKeyException;
import com.criticalweb.ksp.mod.explorer.forms.Login;
import com.criticalweb.ksp.mod.explorer.forms.Register;
import com.criticalweb.ksp.mod.explorer.notifications.NotificationService;
import com.criticalweb.ksp.mod.explorer.session.SessionUser;
import com.criticalweb.ksp.mod.explorer.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */
@Controller
@RequestMapping("/login")
@SessionAttributes("sessionUser")
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Resource
	UserService userService;

	@Resource
	NotificationService notificationService;

	@RequestMapping("")
	public ModelAndView login() {
		return new ModelAndView("login/login", "login", new Login());
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView doLogin(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult) {

		if (bindingResult.getFieldErrors().size() > 0) {
			return new ModelAndView("login/login", "login", login);
		}

		try {
			User user = userService.getUserByLogin(login.getUsername(), login.getPassword());

			SessionUser sessionUser = new SessionUser();
			sessionUser.setUsername(user.getUsername());
			sessionUser.setDisplayname(user.getDisplayname());
			sessionUser.setEmail(user.getEmail());
			sessionUser.setActive(user.isActive());

			ModelAndView mv = new ModelAndView("redirect:/");
			mv.addObject("sessionUser", sessionUser);
			return mv;

		} catch (EntityNotFoundException e) {
			bindingResult.reject("form.login.failed");
			return new ModelAndView("login/login", "login", login);
		}

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("login/register", "register", new Register());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute("register") Register register, BindingResult bindingResult) {

		if (bindingResult.getFieldErrors().size() > 0) {
			return new ModelAndView("login/register", "register", register);
		}

		try {
			User user = userService.createNewUser(register.getUsername(), register.getPassword(), register.getEmail(),
					register.getDisplayname());

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
					.getRequest();

			notificationService.sendRegistrationMessage(user, (String) request.getAttribute("baseUrl"));

			ModelAndView mv = new ModelAndView("redirect:/login/registration-complete");
			return mv;

		} catch (ExpandedEntityExistsException e) {

			for (String field : e.getFields()) {
				bindingResult.rejectValue(field, String.format("form.register.fields.%s.exists", field));
			}

			return new ModelAndView("login/register", "register", register);

		}

	}

	@RequestMapping(value="/activate/{activationKey}", method = RequestMethod.GET)
	public ModelAndView activate(@PathVariable String activationKey) {

		ModelAndView mv = new ModelAndView("login/activate");

		try {
			userService.activateUser(activationKey);
			mv.addObject("success", true);
		} catch (InvalidActivationKeyException e) {
			mv.addObject("success", false);
		}
		return mv;
	}

	@RequestMapping(value = "/registration-complete")
	public ModelAndView registrationComplete() {
		return new ModelAndView("login/registrationComplete");
	}

}
