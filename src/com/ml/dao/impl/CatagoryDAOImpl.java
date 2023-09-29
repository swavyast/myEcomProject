package com.ml.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ml.dao.CatagoryDAO;
import com.ml.pojo.Catagory;

@Repository("catagoryDAO")
@Transactional
public class CatagoryDAOImpl implements CatagoryDAO {
	@Autowired
	SessionFactory sessionFactory=null;

	@Override
	public boolean addCatagory(Catagory catagory) {
		try {
			sessionFactory.getCurrentSession().save(catagory);
		return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCatagory(Catagory catagory) {
		try {
			sessionFactory.getCurrentSession().update(catagory);
		return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCatagory(Catagory catagory) {
		try {
			sessionFactory.getCurrentSession().delete(catagory);
		return true;
		}catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Catagory> listCatagories() {
		Session session=sessionFactory.openSession();
		List<Catagory> listOfCatagories=session.createQuery("from Catagory").getResultStream().toList();
		//Query query=session.createQuery("from Catagory");
		//List<Catagory> listOfCatagories=query.getResultList();
		session.close();
		return listOfCatagories;
	}

	@Override
	public Catagory getCatagory(int catId) {
		Session session=sessionFactory.openSession();
		Catagory cat=session.get(Catagory.class, catId);
		session.close();
		return cat;
	}

}
