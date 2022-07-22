package Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PromptMessage
  {
      public static final String ANSI_RESET = "\u001B[0m";
      public static final String ANSI_YELLOW = "\u001B[33m";

      public  void welcomeMessage(String storeName) {
          System.out.println(ANSI_YELLOW+"Welcome to "+ storeName + ". Are you a customer or a manager ?"+ANSI_RESET);
          System.out.println(ANSI_YELLOW+"1. Customer"+ANSI_RESET);
          System.out.println(ANSI_YELLOW+"2. Manager"+ANSI_RESET);


        }
    //Display list of products
      public  void productListDisplay(HashMap<String,Product> products) throws InterruptedException {
          TimeUnit.SECONDS.sleep(2);

          System.out.println("This are the products we currently have for sale");
          System.out.println("|-----------------|-----------------|--------------------|");
          System.out.println("|    Product      |     Price       |       Quantity     |");
          System.out.println("|.................|.................|....................|");

          int count = 1;
         // String[] cont = {"Cookies","Snacks","Crackers","Bars"};

              for(Map.Entry<String,Product> cnt : products.entrySet()) {

                Product list = products.get(cnt.getKey());{
                  double price = list.getProductPrice();
                  String proName = list.getProductName();
                  long Quantity = list.getProductQuantity();
                  System.out.println(list.getProductCategory());
                  System.out.println(ANSI_YELLOW+count + ":" + proName + "                " + "#" + price + "                  " + Quantity+ANSI_RESET);
                  count++;
                }
              }
          System.out.println("------------------------------------------------------------");

              }

        public  void productChoice()
        {
          System.out.println("Enter The Product you will like to purchase");

        }

        public  void askCustomerName()
          {
            System.out.println("Name of Customer ?");

          }

  }
