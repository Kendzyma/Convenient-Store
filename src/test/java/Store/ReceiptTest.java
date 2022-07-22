package Store;

import Store.Customer.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptTest {
   static List<Customer> customers;
   static Receipt receipt;
    @BeforeAll
   static void setUp() {
         customers = List.of(new Customer("kenny",101,List.of(
                new Product("Bars","Carrot",33,1.4))));
         receipt = new Receipt();

    }

    @Test
    void printReceiptshouldSucceed() {
        int acutual = receipt.printReceipt(customers,"Jumia","Kenny");

        Assertions.assertEquals(1,acutual);
    }

}