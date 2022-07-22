package Store;

import Store.Enum.Roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager extends Staff {
  private String managerName;
  private Cashier cashier;
  private Roles role;
  // Hire a cashier


  public Manager(String managerName, Roles role) {
    this.managerName = managerName;
    this.role = role;
  }

//  public String addProducts(List<Product> products,Roles role) throws IllegalAccessException {
//    if (this.role.equals(role)) {
//      Store store = Store.getInstance();
//      HashMap<String, List<Product>> newProduct = Store.addProductLogic(products);
//      store.setProductList(newProduct);
//    } else {
//      throw new IllegalAccessException("You are not authorised to perform this operation");
//    }
//    return "Product successFully Added";
//  }




    //Hire a cashier
    public boolean hireCashier(Cashier cashier,Roles role) throws IllegalAccessException {
      if (this.role.equals(role)) {
        if (cashier.getAge() >= 18) {
          cashier.setStatus(Roles.CASHIER);
          cashier.setCashierName(cashier.getCashierName());
          cashier.setStatus(Roles.APPLICANT);
          return true;
        }
      }
      else{
        throw new IllegalAccessException("You are not authorised to perform this operation");
      }
      return false;
    }

  }

