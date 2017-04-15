package com.mumat.service.Core;

import java.util.List;
import com.mumat.model.Account;
import com.mumat.model.core.City;

public interface ApplicationUtils {
	public String encryptPassword(String password);
	
	public Account getLoggedInUser();
	
	public boolean matchPassword(String password,String encriptedPassword);
	
	// city
	List<City> getAllCity();
	
	public List<City> getCitiesByState(String state);
}
