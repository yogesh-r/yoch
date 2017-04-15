package com.mumat.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.mumat.bean.SearchBean;
import com.mumat.dao.SearchDao;
import com.mumat.dao.core.AbstractDao;

@Repository("searchDao")
public class SearchDaoImpl extends AbstractDao<Integer, SearchBean> implements SearchDao {

	
	@Override
	public List<SearchBean> findVendors(SearchBean bean) {
		List<SearchBean> results = new ArrayList<SearchBean>();
/*		Criteria criteria = getSession().createCriteria(VendorProfile.class,"pd") 
			    .createAlias("pd.products","vp")
			    .add(Restrictions.eq("vp.keyWord", bean.getSearchProductKeyword()))
			    .add(Restrictions.eq("pd.city", bean.getCityId()));
		
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
			    List list = criteria.list();
			    Iterator itr = list.iterator();
			    
	            while (itr.hasNext()) {
	            	Object object = (Object) itr.next();
	            	SearchBean result = new SearchBean();
	            	VendorProfile thisVendorDetails = (VendorProfile) object;
	            	result.setVendorName(thisVendorDetails.getVendorFirstName());
	            	result.setVendorId(thisVendorDetails.getId());
	            	results.add(result);
	            }
	            */
			    
		return results;
	}
}
