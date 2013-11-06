package com.github.anastasop.elementary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "COUNTRIES")
@NamedQueries({
	@NamedQuery(name = "getAllCountries", query = "select c from Country c")
})
public class Country {
	@Id
	@Column(name = "ID")
	Long id;
	
	@Column(name = "NAME")
	String name;
	
	@Column(name = "CAPITAL")
	String capital;
	
	@Override
	public String toString() {
		return name + ":" + capital;
	}

	public Long getId() {
		return id;
	}

	@JsonIgnore
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	@JsonProperty("capital")
	public void setCapital(String capital) {
		this.capital = capital;
	}
}
