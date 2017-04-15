package com.rjn.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rjn.dao.CandidateProfileDao;
import com.rjn.dao.core.AbstractDao;
import com.rjn.model.CandidateProfile;

@Repository("candidateProfileDao")
public class CandidateProfileDaoImpl extends AbstractDao<Integer, CandidateProfile> implements CandidateProfileDao {

	@Override
	public void saveCandidateRegister(CandidateProfile candidateProfile) {
		persist(candidateProfile);
	}

	@Override
	public List<CandidateProfile> getAllCustomerCompany() {
		Criteria criteria = createEntityCriteria();
		String nullcheck = "null";
		Conjunction objConjunction = Restrictions.conjunction();
		objConjunction.add(Restrictions.isNotNull("custCompanyName"));
		criteria.add(Restrictions.ne("custCompanyName", nullcheck));
		objConjunction.add(Restrictions.isNotNull("companyName"));
		criteria.add(Restrictions.ne("companyName", nullcheck));
		criteria.add(objConjunction);
		return (List<CandidateProfile>) criteria.list();
	}

	@Override
	public CandidateProfile getCandidateProfileByprofileNumber(String profileNumber) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("profileNumber", profileNumber));
		return (CandidateProfile) criteria.uniqueResult();
	}

	@Override
	public CandidateProfile getCandidateProfileByEmail(String contactEmailId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("contactEmailId", contactEmailId));
		return (CandidateProfile) criteria.uniqueResult();
	}

	@Override
	public void saveOrUpdateCandidate(CandidateProfile candidateProfile) {
			update(candidateProfile);
		
	}
}