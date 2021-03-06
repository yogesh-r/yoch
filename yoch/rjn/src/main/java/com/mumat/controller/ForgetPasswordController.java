package com.mumat.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mumat.bean.ChangePassworddBean;
import com.mumat.dao.core.AccountDao;
import com.mumat.model.Account;
import com.mumat.model.PasswordResetToken;
import com.mumat.model.CandidateProfile;
import com.mumat.model.core.Email;
import com.mumat.service.HeaderService;
import com.mumat.service.Core.ApplicationUtils;
import com.mumat.service.Core.MailService;

@Controller
public class ForgetPasswordController {
	
	@Autowired
	private HeaderService headerService;
	
	@Autowired 
	private MailService mailService;
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ApplicationUtils utils;
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.POST)
	public String forgetPassword(ModelMap model, @RequestParam("email") String contactEmailId, HttpServletRequest request) {
		CandidateProfile candidateProfile = headerService.getCandidateProfileByEmail(contactEmailId);
		if (candidateProfile == null) {
			throw new UsernameNotFoundException(contactEmailId);
		} else {
			// generating token
			String token = UUID.randomUUID().toString();
			// saving token in database
			headerService.saveToken(candidateProfile, token);
			// generating forgotpassword link
			String forgotPasswordLink = request.getContextPath() + "/user/changePassword?id=" + 
					candidateProfile.getProfileNumber() + "&token=" + token;
			// sending email
			Email thisEmail = new Email();
			thisEmail.setTo(contactEmailId);
	    	thisEmail.setSubject("Test subject");
	    	thisEmail.setBody("Forgot password link = "+forgotPasswordLink);
	    	boolean isEmailSent = mailService.sendEmail(thisEmail);
	    	System.out.println("isEmailSent: "+isEmailSent);
		}
		return null;
	}
	
	@RequestMapping(value = { "/forgetPassword" }, method = RequestMethod.GET)
	public String forgetPasswordLink(@RequestParam("id") String profileNumber, @RequestParam("token") String token, HttpServletRequest request,  ModelMap model) {
		PasswordResetToken passwordResetToken = headerService.getPasswordResetToken(profileNumber, token);
		// check time also
		// crosscheck with user also
		if (passwordResetToken != null) {
			model.addAttribute("token", token);
			model.addAttribute("profileNumber", profileNumber);
			return "forget-password";
		}
		return null;
	}
	
	@RequestMapping(value = { "/header/change-password" }, method = RequestMethod.POST)
	public String heaerChangePassword(@Valid ChangePassworddBean ChangePassworddBean, BindingResult result, ModelMap model) {
		PasswordResetToken passwordResetToken = headerService.getPasswordResetToken(ChangePassworddBean.getProfileNumber(), ChangePassworddBean.getToken());
		if (passwordResetToken != null && ChangePassworddBean.getNewPassword().equals(ChangePassworddBean.getConformPassword())) {
			//load account
			Account thisAccount =  accountDao.findByRegId(ChangePassworddBean.getProfileNumber());
			thisAccount.setPassword(utils.encryptPassword(ChangePassworddBean.getNewPassword()));
			accountDao.updateAccount(thisAccount);
		}
		return null;
	}
}
