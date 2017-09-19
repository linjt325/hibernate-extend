package com.lin.hibernate_mapping.test;

import org.junit.Test;

import com.lin.hibernate_mapping.base.BaseConnection;
import com.lin.hibernate_mapping.pojo.Customer;
import com.lin.hibernate_mapping.pojo.Order;

public class HibernateMappingTest extends BaseConnection{

	@Test
	public void saveTest(){
		Order order=new Order();
		order.setOrderNumber("123");
		Customer c=new Customer( "XxX");
		order.setCustomer(c);
		//先插入1的一端,后插入多的一段,只有insert [优]
		session.save(c);
		session.save(order);
		
		Order order1=new Order();
		order1.setOrderNumber("1223");
		Customer c1=new Customer( "Xx2X");
		order1.setCustomer(c1);
		//先插入多的一段,后插入1的一端, 先insert 后update
		session.save(order1);
		session.save(c1);
	}
	@Test
	public void many2OneGet(){
		Order order=(Order) session.get(Order.class, 1);
		System.out.println(order);
		//在需要使用到关联的对象时,才发送对应的SQL语句.若此时session已经被关闭,则一定会发生懒加载异常
//		获取OrDER 对象时,默认情况下, 关联的对象是一个代理对象
		Customer c=order.getCustomer();
		System.out.println(c);
	}
	
	@Test
	public void testUpdate(){
		Order order=(Order) session.get(Order.class, 1);
		order.getCustomer().setName("AAA");
		
	}
	@Test
	public void testDelete(){
		//在不设定级联关系的情况下,且1的这一段对象再n的对象中有引用的情况下,  不能被删除
		Customer customer=(Customer) session.get(Customer.class, 3);
		session.delete(customer);
	}
}
