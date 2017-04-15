package com.mumat.service.Core.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mumat.dao.core.AccountDao;
import com.mumat.dao.core.CityDao;
import com.mumat.model.Account;
import com.mumat.model.core.City;
import com.mumat.model.core.Menu;
import com.mumat.model.core.ProductCategory;
import com.mumat.model.core.VendorLead;
import com.mumat.service.Core.ApplicationUtils;

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

