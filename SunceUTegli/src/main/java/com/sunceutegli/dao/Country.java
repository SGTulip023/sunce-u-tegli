package com.sunceutegli.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table(name = "country") 
@NamedQueries ({
	@NamedQuery(name = "allCountry", query = "SELECT c FROM Country c")
})
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cou_id")
	private Integer countryId;
	
	@Column(name = "cou_name")
	private String countryName;
	

	@OneToMany(mappedBy = "country", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	List<City> cities;
	
	public Country() {}

	public Country(String countryName) {
		this.countryName = countryName;
	}
	
	// add convenience methods for bi-directional relationship
	public void add(City tempCity) {
		
		if (cities == null) {
			cities = new ArrayList<City>();
		}
		
		cities.add(tempCity);
		
		// setter
		tempCity.setCountry(this);
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", countryName=" + countryName + "]";
	}	
	
}
