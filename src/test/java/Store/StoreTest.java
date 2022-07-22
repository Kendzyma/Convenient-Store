package Store;

import Store.Enum.ProductStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void addProduct() {
        List<Product> tmp = new ArrayList<>();
        try {
            FileReader file = new FileReader("/Users/mac/Desktop/ConvenientStore/src/main/resources/FoodStore/FoodSales.csv");
            BufferedReader reader = new BufferedReader(file);
            String string;
            int iteration =0;

            while ((string = reader.readLine()) != null) {
                if (iteration == 0){
                    iteration++;
                    continue;
                }
                String[] list1 = string.split(",");

                Assertions.assertNotNull(list1);
                Assertions.assertEquals(8,list1.length);

                Product product = new Product(list1[3], list1[4], Long.parseLong(list1[5]), Double.parseDouble(list1[6]));
                Assertions.assertNotNull(product);


                Boolean found = false;

                if (product.getProductQuantity() > 0)
                {
                    product.setStatus(ProductStatus.INSTOCK);
                    Assertions.assertTrue(product.getProductQuantity()>0);

                }
                else
                {
                    product.setStatus(ProductStatus.OUTOFSTOCK);
                    Assertions.assertTrue(product.getProductQuantity()>0);
                }

                for (Product pro : tmp) {
                    if (product.getProductName().equalsIgnoreCase(pro.getProductName())) {

                        Assertions.assertTrue(product.getProductName().equalsIgnoreCase(pro.getProductName()));

                        pro.setProductQuantity(pro.getProductQuantity() + product.getProductQuantity());
                        found = true;
                    }
                }
                if (!found) {
                    tmp.add(product);
                }
            }
        } catch (IOException | NullPointerException e) {

        }

//        HashMap<String,List<Product>> tmpMap = addProductLogic(tmp);
//        this.productList = tmpMap;
    }

    @Test
    void addProductLogic() {
    }

    @Test
    void getInstance() {
    }

    @Test
    void getProductList() {
    }

    @Test
    void setProductList() {
    }
}