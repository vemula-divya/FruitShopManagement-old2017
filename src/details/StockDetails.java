/**
 This class contain the details of stock
 */
package details;

import java.util.Scanner;

import main.FruitShopManagementSystem;
import daoimpl.StockDAOImpl;

public class StockDetails {
	static Scanner sc = new Scanner(System.in);

	static StockDAOImpl sd1 = new StockDAOImpl();// instantiate a StockDAOImpl class object

	public static void menu() throws ClassNotFoundException {
		while (true) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$     STOCK  DETAILS 	   $");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$  1. INSERT STOCK         $");
			System.out.println("$  2. DISPLAY STOCK    	   $");
			System.out.println("$  3. DELETE STOCK         $");
			System.out.println("$  4. UPDATE STOCK         $");
			System.out.println("$  5. SEARCH STOCK         $");
			System.out.println("$  6. EDIT STOCK           $");
			System.out.println("$  7. BACK  TO MENU        $");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				sd1.addStock();//calling the addStock method of stockdaoimpl
				break;
			case 2:
				sd1.viewStock();//calling the viewStock method of stockdaoimpl
				break;

			case 3:
				sd1.deleteStock();//calling the deleteStock method of stockdaoimpl
				break;
			case 4:
				sd1.updateStock();//calling the updateStock method of stockdaoimpl
				break;
			case 5:
				sd1.searchStock();
				break;
			case 6:
				sd1.editStock();
				break;
			case 7:
				FruitShopManagementSystem.main(null);
				break;
			default:
				System.out.println("Please select choice range 1-6 only");

			}

		}
	}
}