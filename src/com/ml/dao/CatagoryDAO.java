package com.ml.dao;

import java.util.List;

import com.ml.pojo.Catagory;

public interface CatagoryDAO {
	
	public boolean addCatagory(Catagory catagory);
	public boolean updateCatagory(Catagory catagory);
	public boolean deleteCatagory(Catagory catagory);
	
	public List<Catagory> listCatagories();
	public Catagory getCatagory(int catId);
	

}
