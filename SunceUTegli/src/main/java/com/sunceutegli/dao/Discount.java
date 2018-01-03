package com.sunceutegli.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "discount")
public class Discount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dis_id")
	private Integer discountId;
	
	@Column(name = "dis_quantity")
	private int discountQuantity;
	
	@Column(name = "dis_loyalty")
	private int discountLoyalty;
	
	@Column(name = "dis_season")
	private int discountSeason;
	
	@Column(name = "dis_other")
	private int discountOther;
	
	
	// def List<Products>
	@OneToMany(mappedBy = "discount", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	List<Product> products;
	
	// def List<Order>
	@OneToMany(mappedBy = "discount", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	List<OrderPlaced> orderPlaceds;
	
	
	// def constructors
	public Discount() {}

	public Discount(int discountQuantity, int discountLoyalty, int discountSeason, int discountOther) {
		this.discountQuantity = discountQuantity;
		this.discountLoyalty = discountLoyalty;
		this.discountSeason = discountSeason;
		this.discountOther = discountOther;
	}
	
	
	// def 2x add()
	public void addProduct(Product tempProduct) {
		if (products == null) {
			products = new ArrayList<Product>();
		}
		
		products.add(tempProduct);
		
		tempProduct.setDiscount(this);
	}
	
	public void addOrder(OrderPlaced tempOrder) {
		if (orderPlaceds == null) {
			orderPlaceds = new ArrayList<OrderPlaced>();
		}
		
		orderPlaceds.add(tempOrder);
		
		tempOrder.setDiscount(this);
	}
	
	
	// def get i set
	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public int getDiscountQuantity() {
		return discountQuantity;
	}

	public void setDiscountQuantity(int discountQuantity) {
		this.discountQuantity = discountQuantity;
	}

	public int getDiscountLoyalty() {
		return discountLoyalty;
	}

	public void setDiscountLoyalty(int discountLoyalty) {
		this.discountLoyalty = discountLoyalty;
	}

	public int getDiscountSeason() {
		return discountSeason;
	}

	public void setDiscountSeason(int discountSeason) {
		this.discountSeason = discountSeason;
	}

	public int getDiscountOther() {
		return discountOther;
	}

	public void setDiscountOther(int discountOther) {
		this.discountOther = discountOther;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<OrderPlaced> getOrders() {
		return orderPlaceds;
	}

	public void setOrders(List<OrderPlaced> orderPlaceds) {
		this.orderPlaceds = orderPlaceds;
	}

	
	// def toString()
	@Override
	public String toString() {
		return "Discount [discountId=" + discountId + ", discountQuantity=" + discountQuantity + ", discountLoyalty="
				+ discountLoyalty + ", discountSeason=" + discountSeason + ", discountOther=" + discountOther
				+ ", products=" + products + ", orders=" + orderPlaceds + "]";
	}
	
}
