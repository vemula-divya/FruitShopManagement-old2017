/**
 This is the main class for fruitShopManagementSystem
 */
package main;


	import java.util.Scanner;


import details.Bill;
import details.PurchaseDetails;
import details.StockDetails;

	public class FruitShopManagementSystem {

		public static void main(String[] args) throws ClassNotFoundException {

			Scanner sc = new Scanner(System.in);

			while (true) {
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$ ABC FRUIT MANAGEMENT SYSTEM  $");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$  1. STOCK DETAILS            $");
				System.out.println("$  2. PURCHASER  DETAILS       $");
				System.out.println("$  3. BILL PRINT       	       $");
				System.out.println("$  4. Exit                     $");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("Enter Your Choice for this menu");
				int choice = sc.nextInt();
				switch (choice) {
				
				case 1:
					StockDetails.menu();//calling the stockdetails method of stockdetails class
					break;
				case 2:
					PurchaseDetails.menu();//calling the Purchasedetails method of Purchasedetails class
					break;
				case 3:
					Bill.menu();//calling the bill method of bill class
					break;

				case 4:
					System.exit(0);//exits from this menu
				default:
					System.out.println("Please select choice range 1-4 only");

				}
			}

		}

	}


