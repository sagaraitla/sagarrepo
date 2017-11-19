/**
 * 
 */
package com.dotridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dotridge.bean.LoginBean;
import com.dotridge.bean.UserProfileBean;

/**
 * @author Narsaiah
 *
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public String getHomePage() {

		return "home";

	}

	@RequestMapping(value = "/getLoginPage")
	public String getLoginPage(Model model) {
		model.addAttribute("loginBean", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/login")
	public String doLogin(@ModelAttribute("loginBean") LoginBean loginBean) {

		String userId = loginBean.getUserId();
		System.out.println(loginBean);
		if (userId != null && !userId.isEmpty()) {
			if (userId.equalsIgnoreCase("superadmin@email.com")) {
				return "getSuperAdminBoard";
			}

		}
		return "home";
	}

	@RequestMapping(value = "/getSignupPage")
	public String getSingUp(Model model) {
		model.addAttribute("signupBean", new UserProfileBean());
		return "mysignup";

	}

	@RequestMapping(value = "/signup")
	public String doSignUp(@ModelAttribute("signupBean") UserProfileBean userProfileBean) {

		System.out.println(userProfileBean);

		return "mysignup";

	}
}
