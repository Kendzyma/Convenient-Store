package Store;

import Store.Customer.Customer;
import Store.Enum.Roles;
import Store.Interface.IReceipt;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main
  {
    static Store store;
  static Scanner input;
 static Manager manager;
 static PromptMessage message;
    public static void main(String[] args) throws InterruptedException, IllegalAccessException {
        input = new Scanner(System.in);
        message = new PromptMessage();
        //Adding Products to Store
        store = Store.getInstance();
        store.AddProduct();


        Cashier cashier = new Cashier("Odun",19);

        //Employing a new Cashier
         manager = new Manager("kenny", Roles.MANAGER);
       boolean result = manager.hireCashier(cashier,Roles.MANAGER);
       if (!result) {
         System.out.println("Not Employed");
         System.exit(0);
       }

        // Display message
        message.welcomeMessage(new Staff().getStoreName());
        int inputChoice = input.nextInt();

        // Choosing between a customer or a manager
        if (inputChoice == 1) customerSection();
        else ManagerSection();
      }

        public static void customerSection() throws InterruptedException {
        // Show all Products in the store
        message.productListDisplay(store.getProductList());
        store.getProductList();
        message.productChoice();

        // Adding customers Products to cart

            TimeUnit.SECONDS.sleep(2);
//          pro.add(product);
//          CustomerService customerService = new CustomerService(store.getProductList());
//         customerService.updateProduct(pro);
//            List<Product> customerProducts = customerService.getCustomerCart();


          List<Customer> customer = List.of(new Customer("kenny",101,List.of(
                  new Product("Bars","Carrot",85,2.4),new Product("Cookies","Arrowroot",232,1.3),new Product("Crackers","Whole Wheat",23,4.4))),
                  new Customer("Odunayo",102,List.of(new Product("Cookies","Arrowroot",212,0.4))),
                  new Customer("dayo",103,List.of(new Product("Snacks","Potato Chips",342,5.4))),
                  new Customer("leye",104,List.of(new Product("Crackers","Whole Wheat",23,4.4))));



        // Issuing Receipt to customer by the Cashier
            IReceipt receipt = new Receipt();
        var cashier = new Cashier(receipt,store.getProductList());

        message.askCustomerName();
        String name = input.next();
        cashier.validateCustomerProduct(customer);
        cashier.sellProducts(cashier.getStoreName());

      }

        public static void ManagerSection() throws IllegalAccessException {

        List<Product> products = List.of(new Product("Cookies","Sweet",23,1.2));
      //  manager.addProducts(products,Roles.MANAGER);
          System.out.println("This are the new Products added to");
          System.out.println(store.getProductList());


      }

      }
