package com.sunceutegli.dao;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "order_placed")
public class OrderPlaced {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_id")
	private Integer orderId;
	
	@Column(name = "ord_status")
	private String orderStatus;
	
	@Column(name = "ord_date")
	private Date orderDate;
	
	@Column(name = "ord_total_value")
	private double orderTotalValue;
	
	@Column(name = "ord_way_of_delivery")
	private String orderWayOfDelivery;
	
	@Column(name = "ord_date_of_realization")
	private Date orderDateOfRealization;
	
	
	// def rel with User
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "use_id")
	private User user;
	
	// define relation with MethodOfPayment
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "mop_id")
	private MethodOfPayment methodOfPayment;
	
	// def rel with Discount
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "dis_id")
	private Discount discount;
	
	// def List<Item>
	@OneToMany(mappedBy = "orderPlaced", cascade = CascadeType.ALL)
	List<Item> items;
	
	
	// def constuctors
	public OrderPlaced() {}

	public OrderPlaced(String orderStatus, Date orderDate, double orderTotalValue, String orderWayOfDelivery,
			Date orderDateOfRealization, User user, MethodOfPayment methodOfPayment) {
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderTotalValue = orderTotalValue;
		this.orderWayOfDelivery = orderWayOfDelivery;
		this.orderDateOfRealization = orderDateOfRealization;
		this.user = user;
		this.methodOfPayment = methodOfPayment;
	}

	public OrderPlaced(String orderStatus, Date orderDate, double orderTotalValue, String orderWayOfDelivery,
			Date orderDateOfRealization, User user, MethodOfPayment methodOfPayment, Discount discount) {
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderTotalValue = orderTotalValue;
		this.orderWayOfDelivery = orderWayOfDelivery;
		this.orderDateOfRealization = orderDateOfRealization;
		this.user = user;
		this.methodOfPayment = methodOfPayment;
		this.discount = discount;
	}
	
	
	// def add()
	public void addItem(Item tempItem) {
		if (items == null) {
			items = new ArrayList<Item>();
		}
		
		items.add(tempItem);
		
		// setter for order
		tempItem.setOrderPlaced(this);
	}
	

	// def get and set
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotalValue() {
		return orderTotalValue;
	}

	public void setOrderTotalValue(double orderTotalValue) {
		this.orderTotalValue = orderTotalValue;
	}

	public String getOrderWayOfDelivery() {
		return orderWayOfDelivery;
	}

	public void setOrderWayOfDelivery(String orderWayOfDelivery) {
		this.orderWayOfDelivery = orderWayOfDelivery;
	}

	public Date getOrderDateOfRealization() {
		return orderDateOfRealization;
	}

	public void setOrderDateOfRealization(Date orderDateOfRealization) {
		this.orderDateOfRealization = orderDateOfRealization;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MethodOfPayment getMethodOfPayment() {
		return methodOfPayment;
	}

	public void setMethodOfPayment(MethodOfPayment methodOfPayment) {
		this.methodOfPayment = methodOfPayment;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	

	// def toString()
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate
				+ ", orderTotalValue=" + orderTotalValue + ", orderWayOfDelivery=" + orderWayOfDelivery
				+ ", orderDateOfRealization=" + orderDateOfRealization + ", user=" + user + ", methodOfPayment="
				+ methodOfPayment + ", discount=" + discount + ", items=" + items + "]";
	}
		
}
