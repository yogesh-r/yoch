package com.mumat.controller.admin;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.mumat.bean.ChangePassworddBean;
import com.mumat.model.Account;
import com.mumat.service.AccountService;
import com.mumat.service.Core.ApplicationUtils;

@RestController
@RequestMapping("/admin/rest")
public class AdminRestController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public @ResponseBody Object updateVendorPassword(@RequestBody ChangePassworddBean forgetPasswordBean) {
		Map<String, Object> model = new HashMap<String, Object>();
		Account loginUser = utils.getLoggedInUser();
		String dbPassword = loginUser.getPassword();
		String uiOldpassword =forgetPasswordBean.getOldPassword();
		String newpassword=forgetPasswordBean.getNewPassword();
		if (utils.matchPassword(uiOldpassword, dbPassword)) {
			loginUser.setPassword(utils.encryptPassword(newpassword));
			accountService.updatePassword(loginUser);
		} else {
			model.put("result", "Failure");
			return model;
		}
		model.put("result", "success");
		return model;
	}

}
