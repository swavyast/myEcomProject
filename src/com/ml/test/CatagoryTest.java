package com.ml.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ml.dao.CatagoryDAO;
import com.ml.pojo.Catagory;

public class CatagoryTest {
	static CatagoryDAO catagoryDAO;
	
	@BeforeClass
	
	public static void executeFirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		try {
		context.scan("com");
		context.refresh();
		
		catagoryDAO=(CatagoryDAO) context.getBean("catagoryDAO");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			context.close();
		}
	}
	
	@Test
	public void addCatagoryTest() {
		Catagory cat=new Catagory();
		cat.setCatName("T-Shirts");
		cat.setCatDesc("All Varieties of T-Shirts");
		assertTrue("Problem occured! ", catagoryDAO.addCatagory(cat));		
	}

}
