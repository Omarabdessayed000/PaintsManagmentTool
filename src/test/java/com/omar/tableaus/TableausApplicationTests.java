package com.omar.tableaus;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.omar.tableaus.entities.Style;
import com.omar.tableaus.entities.Tableau;
import com.omar.tableaus.repos.StyleRepository;
import com.omar.tableaus.repos.TableauRepository;
import com.omar.tableaus.service.TableauService;

@SpringBootTest
class TableausApplicationTests {

	@Autowired
	private TableauRepository tableauRepository;

	@Autowired
	private TableauService tableauService;

	@Test
	public void testCreateTableau() {
		Tableau tab = new Tableau("The Starry Night", 2200.500, "Vincent van Gogh", new Date());
		tableauRepository.save(tab);
	}

	@Test
	public void testFindTableau() {
		Tableau r = tableauRepository.findById(1L).get();

		System.out.println(r);
	}

	@Test
	public void testUpdateTableau() {
		Tableau r = tableauRepository.findById(1L).get();
		r.setPrixTableau(1000.0);
		tableauRepository.save(r);
	}

	@Test
	public void testDeleteTableau() {
		tableauRepository.deleteById(1L);
	}

	@Test
	public void testListerTousTableaux() {
		List<Tableau> tabs = tableauRepository.findAll();
		for (Tableau r : tabs) {
			System.out.println(r);
		}
	}

	@Test
	public void testFindByNomTableauContains() {
		Page<Tableau> tabs = tableauService.getAllTabsParPage(0, 2);
		System.out.println(tabs.getSize());
		System.out.println(tabs.getTotalElements());
		System.out.println(tabs.getTotalPages());
		tabs.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
	}

	@Test
	public void testFindByNomTableau() {
		List<Tableau> prods = tableauRepository.findByNomTableau("Nighthawks");

		for (Tableau p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByNomTableauContains() {
		List<Tableau> prods = tableauRepository.findByNomTableauContains("w");

		for (Tableau p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Tableau> prods = tableauRepository.findByNomPrix("The Hay Wain", 1000.0);
		for (Tableau p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByStyle() {
		Style S = new Style();
		S.setIdS(1L);
		List<Tableau> prods = tableauRepository.findByStyle(S);
		for (Tableau p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testfindByOrderByNomTableauAsc() {
		List<Tableau> prods =

				tableauRepository.findByOrderByNomTableauAsc();
		for (Tableau p : prods) {
			System.out.println(p);
		}

	}

	@Test
	public void testtrierTableauNomsPrix() {
		List<Tableau> prods = tableauRepository.trierTableauNomsPrix();
		for (Tableau p : prods) {
			System.out.println(p);
		}

	}
	@Test
	public void TestfindByStyleIdS()
	{
	List<Tableau> prods = tableauRepository.findByStyleIdS(1L);
	for (Tableau p : prods)
	{
	System.out.println(p);
	}

	}
	/*****_Style_Test*****/
	
	@Autowired
	private StyleRepository styleRepository;
	
	@Test
	public void testCreateStyle() {
	Style style = new Style("Oil","Oil paintings are one of the oldest forms of painting and remain one of the most popular painting medium types to this day", null);
	styleRepository.save(style);
	}
	
	@Test
	public void testFindStyle() {
		Style r = styleRepository.findById(1L).get();

		System.out.println(r);
	}

}