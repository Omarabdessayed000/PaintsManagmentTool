package com.omar.tableaus.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Tableau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTableau;

	@NotNull
	@Size(min = 5, max = 50)
	@NotBlank(message = "Name is mandatory")
	private String nomTableau;
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double prixTableau;
	
	@NotNull
	@Size(min = 5, max = 50)
	@NotBlank(message = "Painter's name is mandatory")
	private String painterTableau;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;

	@ManyToOne
	public Style style;

	public Tableau() {
		super();
	}

	public Tableau(String nomTableau, Double prixTableau, String painterTableau, Date dateCreation) {
		super();
		this.nomTableau = nomTableau;
		this.prixTableau = prixTableau;
		this.painterTableau = painterTableau;
		this.dateCreation = dateCreation;
	}

	public Long getIdTableau() {
		return idTableau;
	}

	public void setIdTableau(Long idTableau) {
		this.idTableau = idTableau;
	}

	public String getNomTableau() {
		return nomTableau;
	}

	public void setNomTableau(String nomTableau) {
		this.nomTableau = nomTableau;
	}

	public Double getPrixTableau() {
		return prixTableau;
	}

	public void setPrixTableau(Double prixTableau) {
		this.prixTableau = prixTableau;
	}

	public String getPainterTableau() {
		return painterTableau;
	}

	public void setPainterTableau(String painterTableau) {
		this.painterTableau = painterTableau;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Tableau [idTableau=" + idTableau + ", nomTableau=" + nomTableau + ", prixTableau=" + prixTableau
				+ ", painterTableau=" + painterTableau + ", dateCreation=" + dateCreation + "]";
	}

	
}
