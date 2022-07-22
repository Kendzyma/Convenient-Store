package Store;

import Store.Customer.Customer;
import Store.Enum.ProductStatus;
import Store.Enum.Roles;
import Store.Interface.IReceipt;

import java.util.*;

public class Cashier extends Staff {
      private List<Customer> customerCart = new ArrayList<>();
      private HashMap<String,Product> productList;
   private String cashierName;
   private IReceipt receipt;
   private int age;

   private Roles status;

   public Cashier (String cashierName , int age)
   {
       this.cashierName = cashierName;
       this.age = age;
   }


      public  Cashier(IReceipt receipt,HashMap<String,Product> productList)
      {
          this.receipt = receipt;
          this.productList = productList;

      }

      public String validateCustomerProduct(List<Customer> customers)
      {
          List<Customer> customerCart1 = new ArrayList<>();

          for (Customer cart: customers){
              for (Product pro : cart.getProducts())
              if(productList.containsKey(pro.getProductName())) {
                  Product products = productList.get(pro.getProductName());
                      if (products.getProductName().equalsIgnoreCase(pro.getProductName())) {
                          if(products.getStatus().equals(ProductStatus.OUTOFSTOCK) || products.getProductQuantity() < pro.getProductQuantity()) {
                              try {
                                  throw new IllegalAccessException ("Product Out of stock");
                              } catch (IllegalAccessException e) {
                                  throw new RuntimeException(e);
                              }
                          }
                          products.setProductQuantity(products.getProductQuantity() - pro.getProductQuantity());
                          if (products.getProductQuantity() == 0){
                              products.setStatus(ProductStatus.OUTOFSTOCK);
                          }
                          customerCart1.add(cart);
                      }
                  }

              else {
                  throw new NullPointerException("Add a valid product Category");
              }
          }
          sortCustomers(customerCart1);
          return "Success";

      }

      Comparator<Customer> customerComparator = (o1, o2) -> {
       if(o1.getProducts().stream().mapToDouble(a->a.getProductPrice()).sum() < o1.getProducts().stream().mapToDouble(a->a.getProductPrice()).sum()){
           return 1;
       }
       else return -1;
      };
      public void sortCustomers (List<Customer> cus) {
          Queue<Customer> customers = new PriorityQueue<>(customerComparator);

          for (Customer cu : cus) {
              customers.add(cu);
          }
          while (!customers.isEmpty())
          {
              this.customerCart.add(customers.poll());
          }
      }


    // Print Customer Receipt
    public void sellProducts(String storeName) {

          receipt.printReceipt(customerCart,storeName,cashierName);

      }
      public int getAge() {
          return age;
      }

      public void setStatus(Roles status) {
          this.status = status;
      }

      public void setCashierName(String cashierName) {
          this.cashierName = cashierName;
      }

      public String getCashierName() {
          return cashierName;
      }

//    @Override
//    public int compare(Customer o1, Customer o2) {
//
//    }
}
