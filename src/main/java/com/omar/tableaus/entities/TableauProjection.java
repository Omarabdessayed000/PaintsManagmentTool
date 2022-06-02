package com.omar.tableaus.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomTab", types = { Tableau.class })
public interface TableauProjection {
	public String getNomTableau();
}
