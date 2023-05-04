
package bean;


import java.io.Serializable;

public class Purchase implements Serializable {
	public int serialNumber;
	public String fruitName;
	public int quantity;

	public Purchase(int serialNumber, String fruitName, int quantity)
	{
		super();
		this.fruitName = fruitName;
		this.quantity = quantity;
		this.serialNumber = serialNumber;
	}
	/**
	   * Gets the fruitName,quantity,damaged_fruits,serialNumber,
	   * return this fruitName,quantity,damaged_fruits,serialNumber.
	   */

	public String getFruitName()
	{
		return fruitName;
	}

	public void setFruitName(String fruitName)//sets the fruitName
	{
		this.fruitName = fruitName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	//It gives the string representation for current object

	public String toString() {
		return serialNumber + "\t\t\t\t" + fruitName + "\t\t\t\t" + quantity ;
	}

}
