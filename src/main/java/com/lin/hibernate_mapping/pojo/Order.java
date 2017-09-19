package com.lin.hibernate_mapping.pojo;

public class Order {

	private int id;
	
	private String OrderNumber;
	
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order() {
		super();
	}

	public Order(String orderNumber, Customer customer) {
		super();
		OrderNumber = orderNumber;
		this.customer = customer;
	}
	
	
}
