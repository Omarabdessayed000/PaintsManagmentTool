package com.omar.tableaus.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.omar.tableaus.entities.Style;
import com.omar.tableaus.service.StyleService;

@Controller
public class StyleController {

	@Autowired
	StyleService styleservice;

	@RequestMapping("/showCreates")
	public String showCreates() {
		return "createStyle";
	}

	@RequestMapping("/saveStyle")
	public String saveStyle(@ModelAttribute("style") Style style, ModelMap modelMap) throws

	ParseException {
		Style saveStyle = styleservice.saveStyle(style);
		String msg = "style enregistré avec Id " + saveStyle.getIdS();
		modelMap.addAttribute("msg", msg);
		return "createStyle";
	}

	@RequestMapping("/ListeStyles")
	public String listeStyles(ModelMap modelMap) {
		List<Style> prods = styleservice.getAllStyles();
		modelMap.addAttribute("styles", prods);
		return "listeStyles";
	}

	@RequestMapping("/supprimerStyle")
	public String supprimerStyle(@RequestParam("id") Long id, ModelMap modelMap) {
		styleservice.deleteStyleById(id);
		List<Style> prods = styleservice.getAllStyles();
		modelMap.addAttribute("styles", prods);
		return "listeStyles";
	}

	@RequestMapping("/modifierStyle")
	public String editerStyle(@RequestParam("id") Long id, ModelMap modelMap) {
		Style p = styleservice.getStyle(id);
		modelMap.addAttribute("style", p);
		return "editerStyle";
	}

	@RequestMapping("/updateStyle")
	public String updateStyle(@ModelAttribute("style") Style style, ModelMap modelMap) throws ParseException {
		styleservice.updateStyle(style);
		List<Style> prods = styleservice.getAllStyles();
		modelMap.addAttribute("styles", prods);
		return "listeStyles";
	}
}
