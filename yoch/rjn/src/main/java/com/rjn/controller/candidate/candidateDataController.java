package com.rjn.controller.candidate;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.rjn.model.Account;
import com.rjn.model.CandidateProfile;
import com.rjn.service.CandidateService;
import com.rjn.service.Core.ApplicationUtils;

@RestController
@RequestMapping("/candidate/rest")
public class candidateDataController {
	
	@Autowired
	private ApplicationUtils utils;
	
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.GET)
	public @ResponseBody Object candidateEditProfile(HttpServletRequest request) {
		Account loginUser = utils.getLoggedInUser();
		CandidateProfile candidateProfile = getCandidateDetails(loginUser.getReg_id());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("candidateProfile", candidateProfile);
		return model; 
	}
	
	private CandidateProfile getCandidateDetails(String regId){
		return candidateService.getCandidateByProfileNumber(regId);
	}
	
	@RequestMapping(value = { "/edit-profile" }, method = RequestMethod.POST)
	public @ResponseBody Object candidateUpdateProfile(@RequestBody CandidateProfile candidateProfile) {
		candidateService.saveOrUpdateCandidate(candidateProfile);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("result", "success");
		return model;
	}

}
