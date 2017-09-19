package com.lin.hibernate_mapping.pojoBoth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Customer {

	private int id;
	
	private String name;
	
	/**
	 * 1.声明集合类型是,需要使用接口类型, hibernate 在获取集合类型是,反悔的是hibernate 内置的集合类型, 而不是javase 的标准的集合实现
	 * 2.需要把集合进行初始化,可以防止发生空指针异常;
	  */
	private Set<Order> orders=new HashSet<Order>();



	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(  String name) {
		super();
		this.name = name;
	}

	public Customer() {
		super();
	}
	
	
	
}
