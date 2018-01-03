package com.sunceutegli.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@NamedQueries({
	@NamedQuery(name = "allCities", query = "SELECT c FROM City c")
})
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cit_id")
	private Integer cityId;
	
	@Column(name = "cit_name")
	private String cityName;
	
	@Column(name = "cit_postal_code")
	private String cityPostalCode;
	
	
	// postavljam cascade vrednosti, da ne bi doslo do brisanja drzave ukoliko se obrise grad
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "cou_id")
	private Country country;
	
	@OneToMany(mappedBy = "city", cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	List<User> users; 
	

	public City() {}

	public City(String cityName, String cityPostalCode) {
		this.cityName = cityName;
		this.cityPostalCode = cityPostalCode;
	}

	public City(String cityName, String cityPostalCode, Country country) {
		this.cityName = cityName;
		this.cityPostalCode = cityPostalCode;
		this.country = country;
	}
	
	public void add(User tempUser) {
		
		if (users == null) {
			users = new ArrayList<User>();
		}
		
		users.add(tempUser);
		
		tempUser.setCity(this);
	}
	

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityPostalCode() {
		return cityPostalCode;
	}

	public void setCityPostalCode(String cityPostalCode) {
		this.cityPostalCode = cityPostalCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", cityPostalCode=" + cityPostalCode + ", country="
				+ country + "]";
	}
			
}
