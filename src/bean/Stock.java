package bean;

import java.io.Serializable;

public class Stock implements Serializable {
	
	public int serialNumber;
	public String fruitName;
	public int quantityInStock;
	public float wholesalePrice;
	public float retailPrice;
	
	static public float amount;

	public Stock() {
	}

	public Stock(int serialNumber, String fruitName, int quantityInStock,
			float wholesalePrice, float retailPrice) {
		super();
		this.serialNumber = serialNumber;
		this.fruitName = fruitName;
		this.quantityInStock = quantityInStock;
		this.wholesalePrice = wholesalePrice;
		this.retailPrice = retailPrice;
	
	}
	/**
	   * Gets the serialNumber,fruitName,quantityInStock,wholesalePrice,retailPrice 
	   * return this serialNumber,fruitName,quantityInStock,wholesalePrice,retailPrice  .
	   */

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) //setting the serialNumber
	{
		this.serialNumber = serialNumber;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public float getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(float wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public float getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}

	

	@Override
	//It gives the string representation for current object
	public String toString() {

		return serialNumber + "\t\t\t\t" + fruitName + "\t\t\t\t" + quantityInStock
				+ "\t\t\t\t" + wholesalePrice + "\t\t\t\t" + retailPrice ;
				

	}

}