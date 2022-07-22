package Store;

import Store.Customer.Customer;
import Store.Interface.IReceipt;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Receipt implements IReceipt
  {
      public static final String ANSI_RESET = "\u001B[0m";
      public static final String ANSI_YELLOW = "\u001B[33m";

    //Print receipt
    @Override
    public int printReceipt(List<Customer> customers, String storeName, String cashierName)
      {


            double totalAmount = 0;
            int count = 1;
            for (Customer product : customers) {
                System.out.println(ANSI_YELLOW+"            " + product.getCustomerName()+ANSI_RESET);
                System.out.println("|-----------------|-----------------|--------------------|---------------|");
                System.out.println("|    Product      |     Price       |       Quantity     |   Amount      |");
                System.out.println("|-----------------|-----------------|--------------------|---------------|");
                for (Product pro : product.getProducts()) {
                    totalAmount = totalAmount + (pro.getProductPrice() + pro.getProductQuantity());
                    double total = pro.getProductPrice() * pro.getProductQuantity();

                    System.out.println(ANSI_YELLOW+"|" + product.getCustomerId()+":   " + pro.getProductName() + "          " + pro.getProductPrice() + "                   " + pro.getProductQuantity() + "                  #" + String.format("%.2f", total) + "      "+ANSI_RESET);
                    count++;
                }
                System.out.println("----------------------------------------------------------------------------");
                System.out.println(ANSI_YELLOW+"|    Total Amount is:  " + "#" + String.format("%.2f", totalAmount)+ANSI_RESET);
                System.out.println("----------------------------------------------------------------------------");
                try {
                    TimeUnit.SECONDS.sleep(2);
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return 1;
      }
  }
