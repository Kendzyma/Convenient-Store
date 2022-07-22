package Store;

import Store.Customer.Customer;
import Store.Enum.Roles;
import Store.Interface.IReceipt;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CashierTest {
   static IReceipt receipt;
  static List<Customer> list;
  static Cashier cashier;
  static Cashier cashierMock;
  static HashMap<String,List<Product>> product;
  static  List<Product> tmpProduct;
    @BeforeAll
   static void setUp() {
        list = List.of(new Customer("kenny",101,List.of(
                new Product("Bars","Carrot",33,1.4))));

        cashierMock = mock(Cashier.class);
        receipt = mock(Receipt.class);
        when(receipt.printReceipt(list,"Jumia","Dan")).thenReturn(1);

        product = new HashMap<>();
       tmpProduct = List.of(new Product("Bars","Carrot",23,1.1));
        product.put("Bars",tmpProduct);
        cashier = new Cashier(receipt,product);
    }

    @Test
    void sellProductShouldSucceed() {

        //Act
        cashierMock.sellProducts("Jumia");
        doNothing().when(cashierMock).sellProducts(isA(String.class));
        //Assert
        verify(cashierMock,times(1)).sellProducts("Jumia");
    }
    @Test
    void printReceiptShouldReturnSuccess() {
        //Act
         int actual = receipt.printReceipt(list,"Jumia","Dan");

        //Assert
        Assertions.assertEquals(1,actual);
    }
    @Test
    void getAge() {
        //Arrange
        Cashier cashier1 = new Cashier("Dan",18);
        //Act
        int actual = cashier1.getAge();
        //Assert
        Assertions.assertEquals(18,actual);
    }
    @Test
    void setStatus() {
        //Act
        cashierMock.setStatus(Roles.CASHIER);
        doNothing().when(cashierMock).setStatus(isA(Roles.class));

        //Assert
        verify(cashierMock,times(1)).setStatus(Roles.CASHIER);
    }


    @Test
    void setCashierName() {
        //Act
        cashier.setCashierName("Tolani");

        //Assert
        Assertions.assertEquals("Tolani",cashier.getCashierName());
    }
    @Test
    void getCustomerName() {
        //Arrange
        cashier.setCashierName("Odunayo");

        //Act
      String actual =  cashier.getCashierName();

        //Assert
        Assertions.assertEquals("Odunayo",actual);
    }

    @Test
    void CustomerCartsShouldPass() {
    String str = cashier.validateCustomerProduct(list);
       Assertions.assertEquals("Success",str);
    }
    @Test
    void customerCartsShouldthrowANullPointException() throws NullPointerException{
        List<Customer> pro = List.of(new Customer("kenny",101,List.of(
                new Product("Buscuit","Carrot",33,1.4))));

        Throwable exception = Assertions.assertThrows(NullPointerException.class, ()->cashier.validateCustomerProduct(pro));
        Assertions.assertEquals("Add a valid product Category",exception.getMessage());
    }


}