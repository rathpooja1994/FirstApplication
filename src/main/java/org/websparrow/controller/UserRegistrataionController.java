package org.websparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.UserDao;
import org.websparrow.model.User;

@Controller
public class UserRegistrataionController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setUsername(userId);
		user.setPassword(password);

	

		if (userDao.registerUser(user)) {
			mv.addObject("msg", "User registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("registration");

		return mv;

	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(@RequestParam("userId") String userId,
			@RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		User user = new User();
		user.setUsername(userId);
		user.setPassword(password);
		return "Hello World";
	

		
	}


}
