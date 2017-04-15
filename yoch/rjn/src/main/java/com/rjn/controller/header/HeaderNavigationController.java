package com.rjn.controller.header;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rjn.model.CandidateProfile;
import com.rjn.model.SeqId;
import com.rjn.service.HeaderService;
import com.rjn.service.Core.ApplicationUtils;
import com.rjn.service.Core.SequenceGeneratorService;
import com.rjn.utils.Constant;
import com.rjn.utils.SeqConstant;

@Controller
@RequestMapping("/")
public class HeaderNavigationController {
	
	private static final Logger logr = Logger.getLogger(HeaderNavigationController.class);

	@Autowired
	private HeaderService headerService;
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private SequenceGeneratorService seqGenerator;
	
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String index(ModelMap model) {
		//model.put("cityList", utils.getCitiesByState(Constant.STATE_CHHATTISGARH));
		return "index"; 
	}
	
	@RequestMapping(value = { "/contact-us"}, method = RequestMethod.GET)
	public String contact(ModelMap model) {
		return "contact-us";
	}
	
	@RequestMapping(value = { "/login"}, method = RequestMethod.GET)
	public String sighIn(ModelMap model) {
		return "login"; 
	}
	
	@RequestMapping(value = { "/candidate/register"}, method = RequestMethod.GET)
	public String candidateRegister(ModelMap model) {
		return "candidate-register"; 
	}

	@RequestMapping(value = { "/candidate/register"}, method = RequestMethod.POST)
	public String saveCandidateRegisteration(@Valid CandidateProfile candidateProfile, BindingResult result, ModelMap model, RedirectAttributes redirectAttributes) {
		String unEncryptPass = candidateProfile.getPassword();
		candidateProfile.setPassword(utils.encryptPassword(unEncryptPass));
		SeqId seqId = seqGenerator.getSeqId(SeqConstant.CUSTOMER_SEQ);
		String profileNumber = seqId.getSeqName() +"-"+ seqId.getSeqNum();
		candidateProfile.setProfileNumber(profileNumber);
		model.addAttribute("profileNumber", profileNumber);
		model.addAttribute("contactEmail" ,candidateProfile.getContactEmailId());
		headerService.saveCandidateRegistration(candidateProfile);
		return "candidate-register-success";
	}

	@RequestMapping(value = { "/error"}, method = RequestMethod.GET)
	public String error(ModelMap model) {
		return "error";
	}
	
	@RequestMapping(value = { "/logout"}, method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(value = { "/accessdenied"}, method = RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		return "accessdenied";
	}
	
	@RequestMapping(value = "/success-login", method = RequestMethod.GET)
	public ModelAndView successLogin() {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("login-success.jsp", model);
	}
	
}
