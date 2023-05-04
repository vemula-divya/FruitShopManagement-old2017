
/**
Implementation class for purchase 
 */
package daoimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import main.FruitShopManagementSystem;
import bean.Purchase;
import dao.PurchaseDAO;
import details.PurchaseDetails;

public class PurchaseDAOImpl implements PurchaseDAO, Serializable {
    FileInputStream fis = null;
    FileOutputStream fos = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    Scanner sc = new Scanner(System.in);
    List<Purchase> list = null;
    String name;

    StockDAOImpl st = new StockDAOImpl();
    
    int quantity;

    
    public void addPurchase() {
        try {
            list = new ArrayList<Purchase>();
            int ch = 1;
            while (ch == 1) {
                System.out.println("enter serial number");
				String stringserialNumber = sc.next();
				while (!stringserialNumber.matches("[0-9]{1}[0-9]*")) {
					System.err.println("serial number must be a numbers only");
					stringserialNumber = sc.next();
				}
				int serialNumber = Integer.parseInt(stringserialNumber);
                


				System.out.println("enter the name of the fruit");
				name = sc.next();
				while (!name.matches("[A-Z][a-zA-z]*")) // validation for name
				{
					System.err
							.println("Please check the name starts with uppercase. Example:Apple");
					name = sc.next();
				}

				


				System.out.println(" how much quantity you want in-kgs");
               
					
					int quantity = sc.nextInt();
				

               

				Purchase purchase = new Purchase(serialNumber, name, quantity);// parameterised constructor  for  purchase

                /* buying_price, selling_price, total_cost */
                list.add(purchase);
                // UpdateStock.update(name,quantity);
                System.out.println("Successfully fruits are added ");

                
            fos = new FileOutputStream("Fruit.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out .println("Do You want add more  records?\n Press 1->enter fruit details\n press 2->to go purchase details \n press 3->to go to main menu");
            ch = sc.nextInt();
        if(ch==2){
        	PurchaseDetails.menu();
        }
        else if(ch==3)
        {            FruitShopManagementSystem.main(null);

        	
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

		}

    }

    // view record
    public void viewPurchase() {
        try {
            fis = new FileInputStream("Fruit.ser");
            ois = new ObjectInputStream(fis);
            // list = new ArrayList<Purchase>();
           

			System.out.println("serialNumber" + "\t\t\t" + "name" + "\t\t\t"
					+ "  quantity");
            System.out
                    .println("-----------------------------------------------------------------------");
            for (Purchase p : list) {
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // edit record
    
    
    public  void updatePurchase()
    {
        try {
            File oldFile = new File("Fruit.ser");
            File stock = new File("stock.scr");
            FileOutputStream sfos = new FileOutputStream(stock);
            ObjectOutputStream soos = new ObjectOutputStream(sfos);
            fis = new FileInputStream(oldFile);
            ois = new ObjectInputStream(fis);
            
            File newFile = new File("temp.ser");
            fos = new FileOutputStream(newFile);
            oos = new ObjectOutputStream(fos);
            
            System.out.println("Enter Fruit name ?");
            String name =sc.next();
            
            System.out.println("Enter Fruit quantity");
            int quantity1=sc.nextInt();
            //purchase list
            List<Purchase> list = (List<Purchase>) ois.readObject();
            List<Purchase> lists = new ArrayList<Purchase>();
            Iterator it = list.iterator();
            while (it.hasNext()) {

                Purchase p1 = (Purchase) it.next();
                if (p1.fruitName.equals(name)) {
                    System.out.println("present quantity "+p1.quantity);
                    p1.quantity=(p1.quantity-quantity1);
                    lists.add(p1);
                } else {
                    lists.add(p1);
                }
            }
            System.out.println("successfully  fruits are updated");

            System.out.println("updated list "+lists);
            oos.writeObject(lists);
            soos.writeObject(lists);
            soos.flush();
            oldFile.delete();
            newFile.renameTo(oldFile);

            for (Purchase f : lists) {
                System.out.println(f);
            }

            FruitShopManagementSystem.main(null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch(InputMismatchException e)
		{
			e.printStackTrace();

		}
        

    }

    
}
