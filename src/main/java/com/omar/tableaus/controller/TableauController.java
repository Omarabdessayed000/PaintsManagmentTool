package com.omar.tableaus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omar.tableaus.Security.SecurityConfig;
import com.omar.tableaus.entities.Role;
import com.omar.tableaus.entities.Style;
import com.omar.tableaus.entities.Tableau;
import com.omar.tableaus.entities.User;
import com.omar.tableaus.service.TableauService;
import com.omar.tableaus.service.UserService;

@Controller
public class TableauController {

	@Autowired
	TableauService tableauService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {

		List<Style> cats = tableauService.getAllStyles();
		Tableau prod = new Tableau();
		Style cat = new Style();
		cat = cats.get(0); // prendre la première catégorie de la liste
		prod.setStyle(cat); // affedter une catégorie par défaut au produit pour éviter le pb avec une
							// catégorie null
		modelMap.addAttribute("tableau", prod);
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("styles", cats);
		return "formTableau";
	}

	/*
	 * @RequestMapping("/saveTableau") public String
	 * saveTableau(@ModelAttribute("tableau") Tableau tableau, @RequestParam("date")
	 * String date, ModelMap modelMap) throws
	 * 
	 * ParseException { SimpleDateFormat dateformat = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date dateCreation =
	 * dateformat.parse(String.valueOf(date));
	 * tableau.setDateCreation(dateCreation); Tableau saveTableau =
	 * tableauService.saveTableau(tableau); String msg =
	 * "tableau enregistré avec Id " + saveTableau.getIdTableau();
	 * modelMap.addAttribute("msg", msg); return "createTableau"; }
	 */

	@RequestMapping("/saveTableau")
	public String saveTableau(@Valid Tableau tableau, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return "formTableau";
		tableauService.saveTableau(tableau);
		return "formTableau";
	}



	
	@RequestMapping("/rechercher")
	public String rechercher(ModelMap modelMap,@RequestParam("key") String key) {
			List<Tableau> tableaux = tableauService.findAllTableaux(key);
			modelMap.addAttribute("tableaux", tableaux);
			modelMap.addAttribute("key", key);
			return "listeTableaux";

}

	/* listeTableaux */
	@RequestMapping("/ListeTableaux")
	public String listeTableaux(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size) {

		Page<Tableau> tabs = tableauService.getAllTabsParPage(page, size);

		modelMap.addAttribute("tableaux", tabs);
		modelMap.addAttribute("pages", new int[tabs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);

		return "listeTableaux";

	}

	@RequestMapping("/supprimerTableau")
	public String supprimerTableau(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		tableauService.deleteTableauById(id);
		Page<Tableau> tabs = tableauService.getAllTabsParPage(page, size);
		modelMap.addAttribute("tableaux", tabs);
		modelMap.addAttribute("pages", new int[tabs.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);

		return "listeTableaux";
	}

	/*
	 * @RequestMapping("/modifierTableau") public String
	 * editerTableau(@RequestParam("id") Long id, ModelMap modelMap) { Tableau p =
	 * tableauService.getTableau(id); modelMap.addAttribute("tableau", p);
	 * modelMap.addAttribute("mode", "edit"); return "formTableau";
	 */

	@RequestMapping("/modifierTableau")public String editerTableau(@RequestParam("id") Long id,ModelMap modelMap) 
	{ Tableau p =  tableauService.getTableau(id); 
	List<Style> cats = tableauService.getAllStyles(); 
	 modelMap.addAttribute("tableau", p);
	 modelMap.addAttribute("mode", "edit"); 
	 modelMap.addAttribute("styles", cats);
	 return "formTableau"; }

	@RequestMapping("/updateTableau")
	public String updateTableau(@ModelAttribute("tableau") Tableau tableau, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException

	{
//conversion de la date

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		tableau.setDateCreation(dateCreation);
		tableauService.updateTableau(tableau);
		List<Tableau> tabs = tableauService.getAllTableaux();
		modelMap.addAttribute("tableaux", tabs);
		return "listeTableaux";

	}
	
	
	/***************************************/
	/***************************************/
	/***************************************/
	/***************************************/

	
	
	@Autowired
	UserService userService;

	@RequestMapping("/showCreateU")
	public String showCreateU(ModelMap modelMap)
	{
		
	modelMap.addAttribute("user", new User());

	List<Role> role = userService.getRoles();
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("listeroles",role);
	return "formUser";
	}
	@RequestMapping("/saveUser")
	public String saveUser(@Valid User user, BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formUser";
	SecurityConfig sec = new SecurityConfig();
	PasswordEncoder passwordEncoder = sec.passwordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		

	userService.saveUser(user);
	return "redirect:/ListeUsers";
	}

	@RequestMapping("/supprimerUser")
	public String supprimerUser(@RequestParam("id") Long id, ModelMap modelMap,

		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "2") int size) {

		User user =userService.getUsers(id);
		user.setRoles(null);
		userService.updateUsers(user);
		userService.deleteUserById(id);
		Page<User> u = userService.getAllUsersParPage(page,
				size);
		modelMap.addAttribute("users", u);
		modelMap.addAttribute("pages", new int[u.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeUsers";
	}

	@RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id,ModelMap modelMap)
	{
	User u= userService.getUsers(id);
	List<Role> role = userService.getRoles();
	modelMap.addAttribute("user", u);
	modelMap.addAttribute("listeroles",role);
	modelMap.addAttribute("mode", "edit");

	return "formUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		SecurityConfig sec = new SecurityConfig();
		 PasswordEncoder passwordEncoder = sec.passwordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	 userService.updateUsers(user);
	 List<User> ge= userService.getAllUsers();
	 List<Role> role = userService.getRoles();
	 modelMap.addAttribute("users", ge);
	modelMap.addAttribute("listeroles",role);
	return "listeUsers";
	}

	@RequestMapping("/ListeUsers")
	public String listeUsers(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<User> u = userService.getAllUsersParPage(page, size);
	modelMap.addAttribute("users", u);

	modelMap.addAttribute("pages", new int[u.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeUsers";
	}
}
