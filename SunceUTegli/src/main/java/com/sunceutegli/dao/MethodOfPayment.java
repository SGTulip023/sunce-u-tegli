package com.sunceutegli.dao;

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
@Table(name = "method_of_payment")
public class MethodOfPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mop_id")
	private Integer methodOfPaymentId;
	
	@Column(name = "mop_type")
	private String methodOfPaymentType;
	
	
	// def List<Order>
	@OneToMany(mappedBy="methodOfPayment", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	List<OrderPlaced> orderPlaceds;
	
	
	// def constructors
	public MethodOfPayment() {}

	public MethodOfPayment(String methodOfPaymentType) {
		this.methodOfPaymentType = methodOfPaymentType;
	}

	// def add() not for now
	
	// def getters and setters
	public Integer getMethodOfPaymentId() {
		return methodOfPaymentId;
	}

	public void setMethodOfPaymentId(Integer methodOfPaymentId) {
		this.methodOfPaymentId = methodOfPaymentId;
	}

	public String getMethodOfPaymentType() {
		return methodOfPaymentType;
	}

	public void setMethodOfPaymentType(String methodOfPaymentType) {
		this.methodOfPaymentType = methodOfPaymentType;
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
		return "MethodOfPayment [methodOfPaymentId=" + methodOfPaymentId + ", methodOfPaymentType="
				+ methodOfPaymentType + ", orders=" + orderPlaceds + "]";
	}	

}
