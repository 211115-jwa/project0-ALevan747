package com.revature.beans;

import java.util.Objects;

public class Candy {
	Integer id;
	String name = "name";
	String brand = "brand";
	String flavor = "flavor";
	Boolean isSugarFree = false;
	Boolean inStock;
	
	public Candy() {
		id = 0;
		name = "Candy";
		brand = "Brand";
		flavor = "Flavor";
		isSugarFree = false;
		inStock = true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public Boolean getIsSugarFree() {
		return isSugarFree;
	}

	public void setIsSugarFree(Boolean isSugarFree) {
		this.isSugarFree = isSugarFree;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	
	
	//needs work
	@Override
	public int hashCode() {
		return Objects.hash(brand, flavor, id, inStock, isSugarFree, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candy other = (Candy) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(flavor, other.flavor)
				&& Objects.equals(id, other.id) && Objects.equals(inStock, other.inStock)
				&& Objects.equals(isSugarFree, other.isSugarFree) && Objects.equals(name, other.name);
	}
	
	
	

}
