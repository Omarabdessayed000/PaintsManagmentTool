package com.omar.tableaus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.omar.tableaus.entities.Style;
import com.omar.tableaus.entities.Tableau;
import com.omar.tableaus.repos.StyleRepository;
import com.omar.tableaus.repos.TableauRepository;
import com.omar.tableaus.service.TableauService;

@Service
public class TableauServiceImpl implements TableauService {

	@Autowired
	TableauRepository tableauRepository;
	
	@Autowired
	StyleRepository styleRepository;
	
	@Override
	public Tableau saveTableau(Tableau r) {
		return tableauRepository.save(r);
	}

	@Override
	public Tableau updateTableau(Tableau r) {
		return tableauRepository.save(r);
	}

	@Override
	public void deleteTableau(Tableau r) {
		tableauRepository.delete(r);

	}

	@Override
	public void deleteTableauById(Long id) {
		tableauRepository.deleteById(id);

	}

	@Override
	public Tableau getTableau(Long id) {
		return tableauRepository.findById(id).get();
	}

	@Override
	public List<Tableau> getAllTableaux() {
		return tableauRepository.findAll();
	}

	@Override
	public Page<Tableau> getAllTabsParPage(int page, int size) {
		return tableauRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Tableau> findByNomTableau(String nom) {
		return tableauRepository.findByNomTableau(nom);

	}

	@Override
	public List<Tableau> findByNomTableauContains(String nom) {
		return tableauRepository.findByNomTableauContains(nom);
	}

	@Override
	public List<Tableau> findByNomPrix(String nom, Double prix) {
		return tableauRepository.findByNomPrix(nom, prix);

	}

	@Override
	public List<Tableau> findByStyle(Style style) {
		return tableauRepository.findByStyle(style);
	}

	@Override
	public List<Tableau> findByOrderByNomTableauAsc() {
		return tableauRepository.findByOrderByNomTableauAsc();
	}

	@Override
	public List<Tableau> trierTableauNomsPrix() {
		return tableauRepository.trierTableauNomsPrix();
	}

	@Override
	public List<Tableau> findByStyleIdS(Long id) {
		return tableauRepository.findByStyleIdS(id);

	}

	@Override
	public List<Style> getAllStyles() {
		return styleRepository.findAll();

	}

	@Override
	public List<Tableau> findAllTableaux(String key) {
			if  (key != null ) {
				return tableauRepository.search(key);
			}
		return (List<Tableau>) tableauRepository.findAll();
	}

}
