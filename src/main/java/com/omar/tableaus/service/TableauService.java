package com.omar.tableaus.service;

import java.util.List;

import org.springframework.data.domain.Page;
import com.omar.tableaus.entities.Style;
import com.omar.tableaus.entities.Tableau;

public interface TableauService {
	
	  Tableau saveTableau(Tableau r);
	  Tableau updateTableau(Tableau r);
	  void deleteTableau(Tableau r);
	  void deleteTableauById(Long id);
	  Tableau getTableau(Long id);
	  List<Tableau> getAllTableaux();
	  List<Style> getAllStyles();
	  List<Tableau> findAllTableaux(String key);
	  List<Tableau> findByNomTableau(String nom);
	  List<Tableau> findByNomPrix (String nom, Double prix);
	  List<Tableau> findByStyle (Style style);
	  List<Tableau> findByStyleIdS(Long id);
	  List<Tableau> findByOrderByNomTableauAsc();
	  List<Tableau> trierTableauNomsPrix ();
	  Page<Tableau> getAllTabsParPage(int page, int size);
	  List<Tableau> findByNomTableauContains(String nom);
	  
	  
	
	
}
