package Store;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.List;


import static org.mockito.Mockito.*;

class PromptMessageTest {
   static PromptMessage message;
   static HashMap<String,List<Product>> productList;

@BeforeAll
static void setUp() {
     message = mock(PromptMessage.class);
   List list = List.of(new Product("Bars","Carrot",33,1.5));
}
    @Test
    void welcomeMessage() {
        doNothing().when(message).welcomeMessage(isA(String.class));

        message.welcomeMessage("Jumia");

        verify(message,times(1)).welcomeMessage("Jumia");
    }

    @Test
    void productListDisplay() throws InterruptedException {
        message.productListDisplay(productList);
        doNothing().when(message).productListDisplay(isA(HashMap.class));

        verify(message,times(1)).productListDisplay(productList);
    }


    @Test
    void productChoice() {
        message.productChoice();
        doNothing().when(message).productChoice();

        verify(message,times(1)).productChoice();
    }

    @Test
    void askCustomerName() {
        message.askCustomerName();
        doNothing().when(message).askCustomerName();

        verify(message,times(1)).askCustomerName();
    }
}