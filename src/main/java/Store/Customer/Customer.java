package Store.Customer;

import Store.Enum.ProductStatus;
import Store.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Customer
{
    private String CustomerName;
    private int customerId;

    List<Product> products;

    public Customer(String customerName, int customerId,List<Product> products) {
        CustomerName = customerName;
        this.customerId = customerId;
        this.products = products;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getCustomerId() {
        return customerId;
    }
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() && getCustomerName().equals(customer.getCustomerName()) && getProducts().equals(customer.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getCustomerId(), getProducts());
    }
}
