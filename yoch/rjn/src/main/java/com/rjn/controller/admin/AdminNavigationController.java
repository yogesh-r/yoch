package com.rjn.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.rjn.bean.ChangePassworddBean;
import com.rjn.model.Account;
import com.rjn.service.AccountService;
import com.rjn.service.Core.ApplicationUtils;

@Controller 
@RequestMapping("/admin")
public class AdminNavigationController {

	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String whyUs(ModelMap model, HttpServletRequest request) {
		return "admin/admin_home";
	}
	
	@RequestMapping(value = { "/city-list" }, method = RequestMethod.GET)
	public String cityList(ModelMap model) {
		return "admin/city-list";
	}

	@RequestMapping(value = { "/location-list" }, method = RequestMethod.GET)
	public String locationList(ModelMap model) {
		return "admin/location-list";
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String adminEditProfile(ModelMap model) {
		return "admin/admin-edit-profile";
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String adminChangePassword(ModelMap model) {
		return "admin/admin_change_password";
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public String adminChangePassword(@Valid ChangePassworddBean forgetPasswordBean,BindingResult result,ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
		
		if (utils.matchPassword(uiOldpassword, dbPassword)) {
			loginUser.setPassword(utils.encryptPassword(newpassword));
			accountService.updatePassword(loginUser);
		} else {
			return "wrong-password";
		}
		return null;
	
	}
	
	@RequestMapping(value = { "/enquiry-list" }, method = RequestMethod.GET)
	public String enquiry_list(ModelMap model) {
		return "admin/enquiry_list";
	}
}
