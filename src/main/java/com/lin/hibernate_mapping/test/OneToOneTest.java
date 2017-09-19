package com.lin.hibernate_mapping.test;

import org.junit.Test;

import com.lin.hibernate_mapping.base.BaseConnection;
import com.lin.hibernate_mapping.pojoOne2One.Department;
import com.lin.hibernate_mapping.pojoOne2One.Manager;

public class OneToOneTest extends BaseConnection{

	@Test
	public void test(){
		Manager ma=new Manager();
		
		Department dep=new Department();
		
		ma.setName("XxX");
		dep.setDepartName("倒灶");
		dep.setManager(ma);
		
		session.save(dep);
		
	}
	
	
	public void testGet(){
		
	}
}
