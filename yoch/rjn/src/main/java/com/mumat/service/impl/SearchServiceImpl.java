package com.mumat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mumat.bean.SearchBean;
import com.mumat.dao.SearchDao;
import com.mumat.service.SearchService;

@Service("searchService")
@Transactional
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao dao;

	public List<SearchBean> findVendors(SearchBean bean) {
		return dao.findVendors(bean); 
	}
}
