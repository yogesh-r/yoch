package com.mumat.dao;

import java.util.List;

import com.mumat.bean.SearchBean;

public interface SearchDao {
	List<SearchBean> findVendors(SearchBean bean);
}
