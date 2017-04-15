package com.rjn.service;

import java.util.List;

import com.rjn.bean.SearchBean;

public interface SearchService {

	List<SearchBean> findVendors(SearchBean bean);
}
