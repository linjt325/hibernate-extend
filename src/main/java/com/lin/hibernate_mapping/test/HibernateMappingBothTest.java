package com.lin.hibernate_mapping.test;

import org.junit.Test;

import com.lin.hibernate_mapping.base.BaseConnection;
import com.lin.hibernate_mapping.pojoBoth.Customer;
import com.lin.hibernate_mapping.pojoBoth.Order;

public class HibernateMappingBothTest extends BaseConnection{

	@Test
	public void saveTest(){
		Order order=new Order();
		Order order1=new Order();
		order.setOrderNumber("123");
		order1.setOrderNumber("1223");
//		Customer c=(Customer) session.get(Customer.class, 1);
		Customer c=new Customer("XxX");
		c.getOrders().add(order);
		c.getOrders().add(order1);
		order.setCustomer(c);
		order1.setCustomer(c);
		//先插入1的一端,后插入多的一段, 有两个insert 一个update  
		//可以再1的一端的set节点 指定inverse=true 来使1的一端放弃维护关联关系! 这样就没有update 语句了
		session.save(c);
		session.save(order);
		session.save(order1);
		
//		Order order1=new Order();
//		order1.setOrderNumber("1223");
//		Customer c1=new Customer( "Xx2X");
//		order1.setCustomer(c1);
//		c1.getOrders().add(order1);
//		//先插入多的一段Order,后插入1的一端Customer, 先insert 后update  先将各自对象插入, 需要维护两端的关系
//		session.save(order1);
//		session.save(c1);
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
	public void one2ManyGet(){
		//1.对n的一端集合使用延迟加载 
		Customer c=(Customer) session.get(Customer.class,5);
		System.out.println(c.getName());
		//2.返回的多的一段的集合为hibernate的内置集合类型
		System.out.println(c.getOrders().getClass());
		System.out.println(c.getOrders());
		//在需要使用到关联的对象时,才发送对应的SQL语句.若此时session已经被关闭,则一定会发生懒加载异常
//		获取OrDER 对象时,默认情况下, 关联的对象是一个代理对象
	}
	
	@Test
	public void testUpdate(){
		Order order=(Order) session.get(Order.class, 1);
		order.getCustomer().setName("AAA");
		
	}
	@Test
	public void testDelete(){
		//在不设定级联关系的情况下,且1的这一段对象再n的对象中有引用的情况下,  不能被删除
		Customer customer=(Customer) session.get(Customer.class, 2);
		session.delete(customer);
	}
	@Test
	public void testCascade(){
		Customer customer=(Customer) session.get(Customer.class, 1);
		session.delete(customer);	
	}
}
