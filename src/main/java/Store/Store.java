package Store;

import Store.Enum.ProductStatus;
import Store.Enum.Roles;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Store {
    private HashMap<String,Product> productList = new HashMap<>();
    private static Store store;
    public void AddProduct() {
       HashMap<String,Product> tmpProd = new HashMap<>();


        try( BufferedReader reader = new BufferedReader(new FileReader( "/Users/mac/Desktop/ConvenientStore/src/main/resources/FoodStore/FoodSales.csv"))) {
            String string;
            int iteration = 0;
            while ((string = reader.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] list1 = string.split(",");
                Product product = new Product(list1[3], list1[4], Long.parseLong(list1[5]), Double.parseDouble(list1[6]));


                if (tmpProd.containsKey(list1[4])) {
                  Product pro =  tmpProd.get(list1[4]);
                  pro.setProductQuantity(product.getProductQuantity() + pro.getProductQuantity());
                  tmpProd.put(list1[4],pro);
                } else {
                    tmpProd.put(list1[4], product);
                    if(product.getProductQuantity() > 0)
                    {
                        product.setStatus(ProductStatus.INSTOCK);
                    }
                }
            }
            this.productList = tmpProd;
        }
        catch (IOException | NullPointerException e) {

        }
    }

    // Adding Products to Store
    public static Store getInstance()
    {
        if (store == null)
        {
            store = new Store();
        }
        return store;
    }

    public HashMap<String, Product> getProductList() {

        return productList;
    }

    @Override
    public String toString()
    {
        return "Store{" +
                "productList=" + productList +
                '}';
    }
//Check input from the user
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Store)) return false;
        Store store = (Store) o;
        return getProductList().equals(store.getProductList());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getProductList());
    }

    public void setProductList(HashMap<String, Product> productList) {
        this.productList = productList;
    }
}
