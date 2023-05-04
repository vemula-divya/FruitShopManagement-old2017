/**
 This class is to print  Bill of FruitShop
 */
package details;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.List;

import bean.Purchase;
import bean.Stock;
import daoimpl.StockDAOImpl;

public class Bill {
/*
 * Declaring the files
 * */
	static FileInputStream fis = null;
	static FileOutputStream fos = null;
	static ObjectInputStream ois = null;
	static ObjectOutputStream oos = null;
	static FileInputStream fis1 = null;
	static FileOutputStream fos1 = null;
	static ObjectInputStream ois1 = null;
	static ObjectOutputStream oos1 = null;
	static List<Purchase> lists = null;
	static List<Stock> list = null;

	static float totalBill=0;
	public static void menu() 
	{
		StockDAOImpl s1 = new StockDAOImpl(); // instantiate a StockDAOImpl class object

		try {

			File oldFile = new File("Fruit.ser");
			File newFile = new File("temp.ser");
			fis = new FileInputStream(oldFile);
			ois = new ObjectInputStream(fis);

			fos = new FileOutputStream(newFile);
			oos = new ObjectOutputStream(fos);

			File oldFile1 = new File("stock.scr");
			File newFile1 = new File("temp1.ser");
			fis1 = new FileInputStream(oldFile1);
			ois1 = new ObjectInputStream(fis1);
			fos1 = new FileOutputStream(newFile1);
			oos1 = new ObjectOutputStream(fos1);
			Stock ss = null;
			float amount = 0;
			// stock list
			List<Stock> list1 = (List<Stock>) ois1.readObject();
			// purchase list
			@SuppressWarnings("unchecked")
			List<Purchase> list2 = (List<Purchase>) ois.readObject();
			List<Stock> updateList = new ArrayList<Stock>();
			
		
			
			//For printing Current Date and Time
			Date d=new Date();
			DateFormat df=DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT);
			String result=df.format(d);
			System.out.println("\t\t\tDate:"+result);
			
			System.out.println("\t\t****************************************\t\t");
            System.out.println("\t\t\t  ABC FRUIT SHOP BILL   \t\t\t");
			System.out.println("\t\t****************************************\t\t");

			System.out.println("SerialNumber" + "\t\t" + "fruitName" + "\t\t"
					+ "quantity" + "\t\t" + "rate" + "\t\t" + "amount");
			System.out
					.println("---------------------------------------------------------------------------------------------");

			for (Stock s : list1) {
				for (Purchase p : list2) {
					if (s.fruitName.equals(p.fruitName)) {
						ss = new Stock();
						amount = s.retailPrice * p.quantity;
						System.out.println(p + "\t\t\t" + s.retailPrice + "\t\t"
								+ amount);
						
						totalBill=amount+totalBill;

						updateList.add(s);
					} else {
						updateList.add(s);
					}

				}
			}
			oos1.writeObject(updateList);

			oldFile1.delete();
			newFile1.renameTo(oldFile1);
			

			
			

			System.out.println("______________________________________________________________________________________________________");

			System.out.println("\t\t\t\t\t\t\t\t\t\tTotal Bill:"+totalBill);
			System.out.println("______________________________________________________________________________________________________");

			System.out.println("\n");
			
			System.out.println("\t\t...THANK YOU...\t\t");
			System.out.println("\t\t...VISIT AGAIN...\t\t");
			System.out.println("\n");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (ConcurrentModificationException e) {

			 e.printStackTrace();
			}
	}

}