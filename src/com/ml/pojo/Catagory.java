package com.ml.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Catagory {
	@Id
	@GeneratedValue
	private long catId;
	private String catName;
	private String catDesc;
	public Catagory() {}
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	@Override
	public String toString() {
		return "Catagory [catId=" + catId + ", catName=" + catName + ", catDesc=" + catDesc + "]";
	}
}
