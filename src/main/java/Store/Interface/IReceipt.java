package Store.Interface;

import Store.Customer.Customer;
import Store.Product;

import java.util.List;

public interface IReceipt
  {
     int printReceipt(List<Customer> customers, String storeName, String cashierName);
  }
