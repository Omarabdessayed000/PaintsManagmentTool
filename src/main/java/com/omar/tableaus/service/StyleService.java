package com.omar.tableaus.service;

import java.util.List;

import com.omar.tableaus.entities.Style;

public interface StyleService {
	
	Style saveStyle(Style p);
	Style updateStyle(Style p);
	void deleteStyle(Style p);
	void deleteStyleById(Long id);
	Style getStyle(Long id);
	List<Style> getAllStyles();

}
