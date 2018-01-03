package com.sunceutegli.dao;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ite_id")
	private Integer itemId;
	
	@Column(name = "ite_quantity")
	private double itemQuantity;
	
	@Column(name = "ite_value")
	private double itemValue;
	
	
	// def rel with Product
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "pro_id")
	private Product product;
	
	// def rel with Order
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "ord_id")
	private OrderPlaced orderPlaced;
	
	
	// def constructors
	public Item() {}

	public Item(double itemQuantity, double itemValue, Product product, OrderPlaced orderPlaced) {
		this.itemQuantity = itemQuantity;
		this.itemValue = itemValue;
		this.product = product;
		this.orderPlaced = orderPlaced;
	}
	

	// def getter and setter
	public double getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(double itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemValue() {
		return itemValue;
	}

	public void setItemValue(double itemValue) {
		this.itemValue = itemValue;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderPlaced getOrderPlaced() {
		return orderPlaced;
	}

	public void setOrderPlaced(OrderPlaced orderPlaced) {
		this.orderPlaced = orderPlaced;
	}

	
	// def toString()
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemQuantity=" + itemQuantity + ", itemValue=" + itemValue + ", product="
				+ product + ", order=" + orderPlaced + "]";
	}

}
