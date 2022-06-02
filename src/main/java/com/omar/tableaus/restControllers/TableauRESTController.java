package com.omar.tableaus.restControllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omar.tableaus.entities.Tableau;
import com.omar.tableaus.service.TableauService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TableauRESTController {

	@Autowired
	TableauService tableauService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Tableau> getAllTableaux() {
		return tableauService.getAllTableaux();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Tableau getTableauById(@PathVariable("id") Long id) {
		return tableauService.getTableau(id);

	}

	@RequestMapping(method = RequestMethod.POST)
	public Tableau createTableau(@RequestBody Tableau tableau) {
		return tableauService.saveTableau(tableau);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Tableau updateTableau(@RequestBody Tableau tableau) {
		return tableauService.updateTableau(tableau);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTableau(@PathVariable("id") Long id) {
		tableauService.deleteTableauById(id);

	}
	
	@RequestMapping(value="/prodscat/{idS}",method = RequestMethod.GET)
	public List<Tableau> getTableauxByIdS(@PathVariable("idS") Long idS) {
	return tableauService.findByStyleIdS(idS);
	}
}
