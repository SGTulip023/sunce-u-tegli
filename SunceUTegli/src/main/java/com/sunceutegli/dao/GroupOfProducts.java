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
@Table(name = "group_of_products")
public class GroupOfProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gop_id")
	private Integer groupOfProductsId;
	
	@Column(name = "gop_name")
	private String groupOfProductsName;
	
	// def List<Product>
	@OneToMany(mappedBy = "groupOfProducts", cascade = CascadeType.ALL)
	List<Product> products;
	
	public GroupOfProducts() {}
	
	public GroupOfProducts(String groupOfProductsName) {
		this.groupOfProductsName = groupOfProductsName;
	}
	
	
	// def add()
	public void add(Product tempProduct) {
		if (products == null) {
			products = new ArrayList<Product>();
		}
		
		products.add(tempProduct);
		
		// postavi seter za grupu
		tempProduct.setGroupOfProducts(this);
	}

	// def getters and setters
	public Integer getGroupId() {
		return groupOfProductsId;
	}

	public void setGroupId(Integer groupId) {
		this.groupOfProductsId = groupId;
	}

	public String getGroupName() {
		return groupOfProductsName;
	}

	public void setGroupName(String groupOfProductsName) {
		this.groupOfProductsName = groupOfProductsName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	// def toString()
	@Override
	public String toString() {
		return "Group [groupId=" + groupOfProductsId + ", groupName=" + groupOfProductsName + ", products=" + products + "]";
	}
		
}
