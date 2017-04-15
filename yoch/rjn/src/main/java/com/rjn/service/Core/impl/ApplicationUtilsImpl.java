package com.rjn.service.Core.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.rjn.dao.core.AccountDao;
import com.rjn.dao.core.CityDao;
import com.rjn.model.Account;
import com.rjn.model.core.City;
import com.rjn.model.core.Menu;
import com.rjn.model.core.ProductCategory;
import com.rjn.model.core.VendorLead;
import com.rjn.service.Core.ApplicationUtils;

@Service
@Transactional
public class ApplicationUtilsImpl implements ApplicationUtils {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public String encryptPassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		return passwordEncoder.encode(password);
	}
	
	@Override
	public Account getLoggedInUser() {
		return accountDao.getLoggedInUser();
	}

	@Override
	public List<City> getAllCity() {
		return cityDao.getAllCity();
	}

	@Override
	public boolean matchPassword(String password, String encriptedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(password, encriptedPassword);
	}

	@Override
	public List<City> getCitiesByState(String state) {
		return cityDao.getCitiesByState(state);
	}
}

