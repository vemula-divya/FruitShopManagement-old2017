/**
Implementation class for Stock
 */
package daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import main.FruitShopManagementSystem;
import bean.Purchase;
import bean.Stock;
import dao.StockDAO;
import details.PurchaseDetails;
import details.StockDetails;

public class StockDAOImpl implements StockDAO {
	/*
	 * declaring files
	 */
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	public static float retailPrice;
	Scanner sc = new Scanner(System.in);
	List<Stock> list = null;// declaring the list

	// Add Stock
	/*
	 * all the details of stock are added to the stock.scr
	 */
	public void addStock() {
		try {
			list = new ArrayList<Stock>();// initialising list
			int ch = 1;
			while (ch == 1) {
				System.out.println("Enter serial number ");
				String stringserialNumber = sc.next();
				while (!stringserialNumber.matches("[0-9]{1}[0-9]*")) {
					System.err.println("serial number must be a numbers only");
					stringserialNumber = sc.next();
				}
				int serialNumber = Integer.parseInt(stringserialNumber);

				System.out.println("Enter name of fruit");
				String name = sc.next();
				while (!name.matches("[A-Z][a-zA-z]*")) {
					System.err
							.println("Please check the name starts with uppercase. Example:Apple");
					name = sc.next();
				}

				System.out.println("Enter quantity of stock in kg");
				String stringquantityInStock = sc.next();
				while (!stringquantityInStock.matches("[0-9]{1}[0-9]*")) {
					System.err
							.println("please check quantity  must be a numbers only");
					stringquantityInStock = sc.next();
				}
				int quantityInStock = Integer.parseInt(stringquantityInStock);

				System.out.println("enter wholesale price of fruits for 1 kg");
				String stringwholesalePrice = sc.next();
				while (!stringwholesalePrice.matches("[0-9]{1}[0-9]*")) {
					System.err
							.println("please check wholesalePrice must be a numbers only");
					stringwholesalePrice = sc.next();
				}
				float wholesalePrice = Integer.parseInt(stringwholesalePrice);

				System.out.println("enter retail price of fruits for 1 kg");

				String stringretailPrice = sc.next();
				/*int i = stringretailPrice(stringwholesalePrice);
				System.out.println(i);
				if(i<0)
				{
					System.out.println("please enter retailprice greater than wholesaleprise");
				}
				else{}*/
				while (!stringretailPrice.matches("[0-9]{1}[0-9]*")) {
					System.err
							.println("please check retailprice must be a numbers only");
					stringretailPrice = sc.next();
				}
				float retailPrice = Integer.parseInt(stringretailPrice);
				
				// parameterised constructor
				Stock stock = new Stock(serialNumber, name, quantityInStock,
						wholesalePrice, retailPrice);
				list.add(stock);
				System.out.println("Successfully fruits  are added into stock");

				fos = new FileOutputStream("stock.scr");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				System.out
						.println("Do You want add more  records?\n Press 1->enter fruit details\n press 2->to go stock details \n press 3->to go to main menu");
				ch = sc.nextInt();
				if (ch == 2) {
					StockDetails.menu();
				} else if (ch == 3) {
					FruitShopManagementSystem.main(null);

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch(InputMismatchException e)
		{
			e.printStackTrace();

		}finally {

		}

	}

	// view Stock
	/*
	 * all the details entered in the add module are stored in a file called
	 * stock.scr this files is now read using the file input stream
	 */
	public void viewStock() {
		try {
			fis = new FileInputStream("stock.scr");
			ois = new ObjectInputStream(fis);
			list = new ArrayList<Stock>();
			list = (List<Stock>) ois.readObject();
			System.out.println("AVALIABILITY OF STOCK IN SHOP");
			System.out.println("\n");
			System.out.println("serialNumber" + "\t\t\t" + "name" + "\t\t\t"
					+ "quantityInStock" + "\t\t\t" + "wholesalePrice"
					+ "\t\t\t" + "retailPrice");
			System.out
					.println("------------------------------------------------------------------------------------------------------------------------------------");
			// System.out.println(list);
			for (Stock p : list) {
				System.out.println(p);
			}
			System.out.println("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/*
	 * In the temp.scr file if fruitname matches it deletes the particular line
	 */

	public void deleteStock() {
		try {
			File oldFile = new File("stock.scr");
			File newFile = new File("temp.scr");
			fis = new FileInputStream(oldFile);
			ois = new ObjectInputStream(fis);
			fos = new FileOutputStream(newFile);
			oos = new ObjectOutputStream(fos);
			System.out.println("Enter fruit name");
			String fruitName = sc.next();
			list = (List<Stock>) ois.readObject();
			List<Stock> lists = new ArrayList<Stock>();
			Iterator it = list.iterator();
			while (it.hasNext()) {

				Stock s1 = (Stock) it.next();
				if (s1.fruitName.equals(fruitName)) {
					lists.remove(s1);
				} else {
					lists.add(s1);
				}
			}
			oos.writeObject(lists);
			oldFile.delete();
			newFile.renameTo(oldFile);
			System.out.println("successfully fruit are deleted");
			FruitShopManagementSystem.main(null);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/*
	 * In this update module stock is updated and stored in stock.scr
	 */

	public void updateStock() {
		int quantity;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		FileInputStream fis1 = null;
		FileOutputStream fos1 = null;
		ObjectInputStream ois1 = null;
		ObjectOutputStream oos1 = null;
		Scanner sc = new Scanner(System.in);
		List<Stock> list = null;

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

			// stock list
			List<Stock> list1 = (List<Stock>) ois1.readObject();
			// purchase list
			@SuppressWarnings("unchecked")
			List<Purchase> list2 = (List<Purchase>) ois.readObject();
			List<Stock> updateList = new ArrayList<Stock>();

			for (Stock s : list1) {
				for (Purchase p : list2) {
					if (s.fruitName.equals(p.fruitName)) {
						s.quantityInStock = (s.quantityInStock - p.quantity);
						updateList.add(s);
					} else {
						updateList.add(s);
					}
				}
			}
			oos1.writeObject(updateList);

			oldFile1.delete();
			newFile1.renameTo(oldFile1);

			System.out.println("successfully update record");
			for (Stock f : list1) {
				System.out.println(f);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ConcurrentModificationException e) {
			// e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			e.printStackTrace();

		}

	}

	/*
	 * name of the fruit is searched from the fruit.ser
	 */

	public void searchStock() {

		try {
			fis = new FileInputStream("Stock.scr");
			ois = new ObjectInputStream(fis);
			System.out.println("enter the name");
			String n = sc.next();
			list = (ArrayList<Stock>) ois.readObject();
			Iterator<Stock> it = list.iterator();
			while (it.hasNext()) {

				Stock f = (Stock) it.next();
				if (f.fruitName.equals(n)) {
					System.out.println(f);
				}

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void editStock() {
		try {
			File oldFile = new File("stock.scr");
			File newFile = new File("temp.scr");
			fis = new FileInputStream(oldFile);
			ois = new ObjectInputStream(fis);
			fos = new FileOutputStream(newFile);
			oos = new ObjectOutputStream(fos);
			System.out.println("Enter fruit name of what you want to change  ");
			String fruitName = sc.next();
			list = (List<Stock>) ois.readObject();
			List<Stock> lists = new ArrayList<Stock>();
			Iterator it = list.iterator();
			while (it.hasNext()) {

				Stock s1 = (Stock) it.next();
				if (s1.fruitName.equals(fruitName)) {
					System.out.println("Enter fruit name");
					s1.setFruitName(sc.next());
					System.out.println("Enter quantity in stock");
					s1.setQuantityInStock(sc.nextInt());
					System.out.println("enter wholesale price");
					s1.setWholesalePrice(sc.nextFloat());
					System.out.println("enter retail price");
					s1.setRetailPrice(sc.nextFloat());
					lists.add(s1);

				} else {
					lists.add(s1);
				}
			}
			oos.writeObject(lists);
			oldFile.delete();
			newFile.renameTo(oldFile);

			FruitShopManagementSystem.main(null);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (ConcurrentModificationException e) {
			// e.printStackTrace();
		}

	}
}