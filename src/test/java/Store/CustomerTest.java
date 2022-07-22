package Store;

import Store.Customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

class CustomerTest {
    static Customer customer;
    @BeforeAll
   static void Setup()
    {
        List<Product> products = List.of(new Product("Bars","Cookies",34,1.5));
        customer = new Customer("Kenny",101,products);
    }

    @Test
    void getCustomerProduct() {

        //Arrange
        List<Product> expected = List.of(new Product("Bars","Cookies",34,1.5));
        //Act
        List<Product> actual =customer.getProducts();
        //Assert
        Assertions.assertEquals(expected,actual);


    }
    @Test
    void getCustomerName()
    {
        //Act
        String expected = "Kenny";
        String actual = customer.getCustomerName();
        //Assert
        Assertions.assertEquals(expected,actual);
    }
    @Test
    void getCustomerId()
    {
        //Act
        int expected = 101;
        int actual = customer.getCustomerId();
        //Assert
        Assertions.assertEquals(expected,actual);
    }

}