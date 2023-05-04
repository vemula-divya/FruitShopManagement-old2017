/**
 This class contain the details of purchase
 */
package details;

import java.util.Scanner;

import main.FruitShopManagementSystem;
import daoimpl.PurchaseDAOImpl;
import daoimpl.StockDAOImpl;

public class PurchaseDetails {
	static Scanner sc = new Scanner(System.in);
	static PurchaseDAOImpl fdi = new PurchaseDAOImpl();// instantiate a PurchaseDAOImpl class object

	public static void menu() throws ClassNotFoundException {
		StockDAOImpl st = new StockDAOImpl(); // instantiate a StockDAOImpl class object
		st.viewStock(); // use the instance st to call a method on it

		while (true) {
			
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$               PURCHASE DETAILS               $");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$         1.INSERT FRUIT TO YOUR CART          $");
			System.out.println("$         2.DISPLAY FRUIT FROM YOUR CART       $");
			System.out.println("$         3.UPDATE FRUIT OF YOUR CART          $");
			System.out.println("$         4.BACK TO MENU                       $");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

			System.out.println("Enter Your Choice for this menu");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				fdi.addPurchase();//calling the addpurchase method of purchasedaoimpl
				break;
			case 2:
				fdi.viewPurchase();//calling the viewpurchase method of purchasedaoimpl
				break;
			

			case 3:
				fdi.updatePurchase();//calling the updatepurchase method of purchasedaoimpl
				break;
			case 4:
				FruitShopManagementSystem.main(null);

			default:
				System.out.println("Please select choice range 1-5 only");

			}
		}
	}

}
