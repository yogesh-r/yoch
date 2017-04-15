package com.mumat.service;

import java.util.List;

import com.mumat.bean.SearchBean;

public interface SearchService {

	List<SearchBean> findVendors(SearchBean bean);
}
