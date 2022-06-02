package com.omar.tableaus.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Style {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idS;
	private String nomS;
	private String descriptionS;

	@JsonIgnore
	@OneToMany(mappedBy = "style")
	private List<Tableau> tableaux;

	public Style() {
	}

	public Style(String nomS, String descriptionS, List<Tableau> tableaux) {
		super();
		this.nomS = nomS;
		this.descriptionS = descriptionS;
		this.tableaux = tableaux;
	}

	public Long getIdS() {
		return idS;
	}

	public void setIdS(Long idS) {
		this.idS = idS;
	}

	public String getNomS() {
		return nomS;
	}

	public void setNomS(String nomS) {
		this.nomS = nomS;
	}

	public String getDescriptionS() {
		return descriptionS;
	}

	public void setDescriptionS(String descriptionS) {
		this.descriptionS = descriptionS;
	}

	public List<Tableau> getTableaux() {
		return tableaux;
	}

	public void setTableaux(List<Tableau> tableaux) {
		this.tableaux = tableaux;
	}

	@Override
	public String toString() {
		return "Style [idS=" + idS + ", nomS=" + nomS + ", descriptionS=" + descriptionS + ", tableaux=" + tableaux
				+ "]";
	}
}
