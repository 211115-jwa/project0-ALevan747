package com.revature.beans;

public class Candy {
	Integer id;
	String name = "name";
	String brand = "brand";
	String flavor = "flavor";
	Boolean isSugarFree = false;
	Boolean inStock = true;
	
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		//result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
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
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		//if (status == null) {
			//if (other.status != null)
				//return false;
		//} else if (!status.equals(other.status))
			//return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", brand=" + brand + ", flavor=" + flavor + "]";
		//status=" + status + "
	}
}
