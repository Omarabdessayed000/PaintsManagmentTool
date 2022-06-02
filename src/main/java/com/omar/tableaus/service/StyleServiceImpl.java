package com.omar.tableaus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omar.tableaus.entities.Style;
import com.omar.tableaus.repos.StyleRepository;

@Service
public class StyleServiceImpl implements StyleService {

	@Autowired
	StyleRepository styleRepository;
	
	@Override
	public Style saveStyle(Style p) {
		return styleRepository.save(p);
	}

	@Override
	public Style updateStyle(Style p) {
		return styleRepository.save(p);
	}

	@Override
	public void deleteStyle(Style p) {
		styleRepository.delete(p);
		
	}

	@Override
	public void deleteStyleById(Long id) {
		styleRepository.deleteById(id);
		
	}

	@Override
	public Style getStyle(Long id) {
		return styleRepository.findById(id).get();
	}

	@Override
	public List<Style> getAllStyles() {
		return styleRepository.findAll();
	}

}
