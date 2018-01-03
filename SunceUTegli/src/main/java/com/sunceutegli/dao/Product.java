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
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private Integer productId;
	
	@Column(name = "pro_name")
	private String productName;
	
	@Column(name = "pro_description")
	private String productDescription;
	
	@Column(name = "pro_storehouse")
	private double productStorehouse;
	
	@Column(name = "pro_picture")
	private String productPicture;
	
	@Column(name = "pro_price")
	private double productPrice;
	
	
	// def rel with Group
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "gop_id")
	private GroupOfProducts groupOfProducts;
	
	// def rel with Discount
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "dis_id")
	private Discount discount;
	
	// def List<Item>
	/*
	@OneToMany(mappedBy = "product", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	List<Item> items;
	*/
	
	// def List<Comment>
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	List<Comment> comments;
	
	
	// def constructors
	public Product() {}

	public Product(String productName, String productDescription, double productStorehouse, String productPicture,
			double productPrice, GroupOfProducts groupOfProducts) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStorehouse = productStorehouse;
		this.productPicture = productPicture;
		this.productPrice = productPrice;
		this.groupOfProducts = groupOfProducts;
	}

	public Product(String productName, String productDescription, double productStorehouse, String productPicture,
			double productPrice, GroupOfProducts groupOfProducts, Discount discount) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStorehouse = productStorehouse;
		this.productPicture = productPicture;
		this.productPrice = productPrice;
		this.groupOfProducts = groupOfProducts;
		this.discount = discount;
	}
	

	// def add()
	public void addComment(Comment tempComment) {
		if (comments == null) {
			comments = new ArrayList<Comment>();
		}
		
		comments.add(tempComment);
		
		tempComment.setProduct(this);
	}
	
	
	// def getters and setters
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductStorehouse() {
		return productStorehouse;
	}

	public void setProductStorehouse(double productStorehouse) {
		this.productStorehouse = productStorehouse;
	}

	public String getProductPicture() {
		return productPicture;
	}

	public void setProductPicture(String productPicture) {
		this.productPicture = productPicture;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public GroupOfProducts getGroupOfProducts() {
		return groupOfProducts;
	}

	public void setGroupOfProducts(GroupOfProducts groupOfProducts) {
		this.groupOfProducts = groupOfProducts;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

	// def toSting()
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productStorehouse=" + productStorehouse + ", productPicture=" + productPicture
				+ ", productPrice=" + productPrice + ", group=" + groupOfProducts + ", discount=" + discount + ", comments="
				+ comments + "]";
	}
	
}
