package com.mumat.controller.candidate;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mumat.bean.ChangePassworddBean;
import com.mumat.bean.SearchBean;
import com.mumat.model.Account;
import com.mumat.model.CandidateProfile;
import com.mumat.service.AccountService;
import com.mumat.service.CandidateService;
import com.mumat.service.SearchService;
import com.mumat.service.Core.ApplicationUtils;

@Controller
@RequestMapping("/candidate")
public class CandidateNavigationController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired  
	private SearchService searchService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = { "/home"}, method = RequestMethod.GET)
	public String paernerHome(ModelMap model, HttpServletRequest request) {
		return "candidate/candidate_home";
	}
	
	@RequestMapping(value = { "/search"}, method = RequestMethod.GET)
	public String candidateSearch(ModelMap model, HttpServletRequest request) {
		Object object =  request.getSession().getAttribute("authorities");
		List loginUser  = (List)object;
		if (loginUser != null) {
			model.put("headerType", loginUser.get(0));
		}
		String productKeyword = (String) request.getParameter("thisProduct");
		SearchBean sb = new SearchBean();
		sb.setSearchProductKeyword(productKeyword);
		model.put("results", searchService.findVendors(sb));
		return "/search/search_branch";
	}
	
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public String candidateEditProfile(ModelMap model) {
		Account loginUser = utils.getLoggedInUser();
		CandidateProfile candidateProfile = getCandidateDetails(loginUser.getReg_id());
		model.addAttribute("candidateDetails", candidateProfile);
		return "candidate/candidate-edit-profile"; 
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.GET)
	public String candidateChangePassword(ModelMap model) {
		return "candidate/candidate_change_password"; 
	}
	
	@RequestMapping(value = { "/change-password" }, method = RequestMethod.POST)
	public String updateCandidatePassword(@Valid ChangePassworddBean forgetPasswordBean,BindingResult result, ModelMap model) {
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

	private CandidateProfile getCandidateDetails(String regId){
		return candidateService.getCandidateByProfileNumber(regId);
	}
}