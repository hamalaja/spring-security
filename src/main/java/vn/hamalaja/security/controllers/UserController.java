package vn.hamalaja.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lamhm
 *
 */
@Controller
public class UserController {

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login(ModelMap model) {
	// model.put("title", "Hello Spring Security");
	// return "login";
	// }

	@RequestMapping(value = "/login-custom")
	public String loginCustom() {
		return "login-custom";
	}


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.put("title", "Hello Spring Security");
		return "login";
	}


	@RequestMapping(value = "/user/info", method = RequestMethod.GET)
	public String info() {
		return "info";
	}
}
