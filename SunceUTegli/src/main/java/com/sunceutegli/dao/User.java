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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "use_id")
	private Integer userId;
	
	@Column(name = "use_first_name")
	private String userFirstName;
	
	@Column(name = "use_last_name")
	private String userLastName;
	
	@Column(name = "use_email")
	private String userEmail;
	
	@Column(name = "use_password")
	private String userPassword;
	
	@Column(name = "use_phone")
	private String userPhone;
	
	@Column(name = "use_address")
	private String userAddress;
	
	@Column(name = "use_postal_address_code")
	private String userPAC;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "cit_id")
	private City city;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<OrderPlaced> orderPlaceds;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	List<Comment> comments;
	
	
	public User() {}

	public User(String userFirstName, String userLastName, String userEmail, String userPassword, String userPhone,
			String userAddress, String userPAC) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userPAC = userPAC;
	}

	public User(String userFirstName, String userLastName, String userEmail, String userPassword, String userPhone,
			String userAddress, String userPAC, City city) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userPAC = userPAC;
		this.city = city;
	}
	
	
	public void addOrder(OrderPlaced tempOrder) {
		if (orderPlaceds == null) {
			orderPlaceds = new ArrayList<OrderPlaced>();
		}
		
		orderPlaceds.add(tempOrder);
		
		// setter
		tempOrder.setUser(this);
	}
	
	public void addComment(Comment tempComment) {
		if (comments == null) {
			comments = new ArrayList<Comment>();
		}
		
		comments.add(tempComment);
		
		// setter
		tempComment.setUser(this);
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPAC() {
		return userPAC;
	}

	public void setUserPAC(String userPAC) {
		this.userPAC = userPAC;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userPhone=" + userPhone
				+ ", userAddress=" + userAddress + ", userPAC=" + userPAC + ", city=" + city + "]";
	}
		
}
