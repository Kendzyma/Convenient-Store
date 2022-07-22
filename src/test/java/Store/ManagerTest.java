package Store;

import Store.Enum.Roles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ManagerTest {

   static Manager manager;
   static Roles role;
   static Store store;
   static List<Product> list;
   static Cashier cashier;
    @BeforeAll
   static void setUp() {
        role = Roles.MANAGER;
        manager = new Manager("Kenny", Roles.MANAGER);
        store = Store.getInstance();
        list = List.of(new Product("Bar","Carrot",12,1.5));
        cashier = new Cashier("Kenny",18);

    }

    @Test
    void addProducts(){
        if (this.role.equals(Roles.CASHIER))
        {
            Assertions.assertTrue(this.role.equals((Roles.MANAGER)));
            HashMap<String, List<Product>> newProduct = Store.addProductLogic(list);
            Assertions.assertNotNull(newProduct);
        }
    }
    @Test
    void addProductShouldThrowIllegalArgumentException () throws IllegalAccessException {

      Throwable exception = Assertions.assertThrows(IllegalAccessException.class,()->manager.addProducts(list,Roles.CASHIER));

      Assertions.assertEquals("You are not authorised to perform this operation",exception.getMessage());
    }

@Test
void addProductShouldSucceed() throws IllegalAccessException {
   String actual =  manager.addProducts(list,Roles.MANAGER);

   Assertions.assertEquals("Product successFully Added",actual);
}

    @Test
    void hireCashierShouldPassWhenAgeIsGreaterThan18() throws IllegalAccessException {
        //Arrange
        Cashier cashierMock = mock(Cashier.class);
        when(cashierMock.getAge()).thenReturn(18);

        //Act
        Boolean actual = manager.hireCashier(cashierMock,Roles.MANAGER);

        //Assert
        Assertions.assertTrue(actual);
    }
    @Test
    void hireCashierShouldThrowIllegalAccessException () throws IllegalArgumentException
    {
        //Arrange
        Cashier cashierMock = mock(Cashier.class);
        when(cashierMock.getAge()).thenReturn(19);
        //Assert
      Throwable exception =  Assertions.assertThrows(IllegalAccessException.class,()->manager.hireCashier(cashierMock,Roles.CASHIER));
      Assertions.assertEquals("You are not authorised to perform this operation",exception.getMessage());
    }
    @Test
    void TestShouldReturnFalseIfAgeIsLessThan18() throws IllegalAccessException {
        //Arrange
        Cashier cashierMock = mock(Cashier.class);
        when(cashierMock.getAge()).thenReturn(12);

        //Act
        Boolean actual = manager.hireCashier(cashierMock,Roles.MANAGER);

        //Assert
        Assertions.assertFalse(actual);
    }
}