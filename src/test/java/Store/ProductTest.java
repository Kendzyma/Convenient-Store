package Store;

import Store.Enum.ProductStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.management.relation.Role;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductTest {
 static Product product;
    @BeforeAll
   static void setUp() {
        product = new Product("Bars","Carrot",89,1.9);
    }

    @Test
    void getProductName() {
     //Act
     String actual = product.getProductName();

     //Assert
     Assertions.assertEquals("Carrot",actual);
    }

    @Test
    void getProductQuantity() {
     //Act
     long actual = product.getProductQuantity();

     //Assert
     Assertions.assertEquals(89,actual);
    }

    @Test
    void getProductCategory() {
     //Act
     String actual = product.getProductCategory();

     //Assert
     Assertions.assertEquals("Bars",actual);
    }

    @Test
    void setProductQuantity() {
     Product productMock = mock(Product.class);
     productMock.setProductQuantity(33);

     doNothing().when(productMock).setProductQuantity(isA(Long.class));
     //Assert
     verify(productMock,times(1)).setProductQuantity(33);
    }

    @Test
    void getProductPrice() {
     //Act

     double actual = product.getProductPrice();

     //Assert
     Assertions.assertEquals(1.9,actual);
    }



    @Test
    void getStatusInstock() {
     //Act
     product.setStatus(ProductStatus.INSTOCK);
     ProductStatus actual = product.getStatus();
     //Assert
     Assertions.assertEquals(ProductStatus.INSTOCK,actual);
    }
 @Test
 void getStatusOutOfstock() {
  //Act
  product.setStatus(ProductStatus.OUTOFSTOCK);
  ProductStatus actual = product.getStatus();
  //Assert
  Assertions.assertEquals(ProductStatus.OUTOFSTOCK,actual);
 }

    @Test
    void setStatus() {
     Product productMock = mock(Product.class);
     productMock.setStatus(ProductStatus.INSTOCK);

     doNothing().when(productMock).setStatus(isA(ProductStatus.class));
     //Assert
     verify(productMock,times(1)).setStatus(ProductStatus.INSTOCK);
    }
}