package com.lin.hibernate_mapping.test;

import org.junit.Test;

import com.lin.hibernate_mapping.base.BaseConnection;
import com.lin.hibernate_mapping.pojoOne2One.foreign.Department;
import com.lin.hibernate_mapping.pojoOne2One.foreign.Manager;

public class OneToOneTestForeign extends BaseConnection{ 

	@Test
	public void test(){
		Manager ma=new Manager();
		
		Department dep=new Department();
		
		ma.setName("XxX");
		dep.setDepartName("倒灶");
		dep.setManager(ma);
		ma.setDepartment(dep);
		session.save(ma);
		session.save(dep);
		
	}
	
	@Test
	public void testGet(){
		Department de=(Department) session.get(Department.class, 1	);
		System.out.println(de);
		System.out.println(de.getManager());
	}
	
	@Test
	public void testGet2(){
		//在查询没有外键的实体对象时 ,使用的是左外连接查询,一并查询处关联的对象
		Manager m=(Manager) session.get (Manager.class, 1);
		System.out.println(m);
		System.out.println(m.getDepartment());
	}
}
