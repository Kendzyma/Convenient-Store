package Store;

import Store.Enum.ProductStatus;

import java.util.Objects;

public class Product
  {
      private String productCategory;
      private String productName;
      private long productQuantity;
      private double productPrice;

      private ProductStatus status;


    public Product(String category, String productName, long productQuantity, double productPrice)
      {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productCategory = category;

      }


    public String getProductName()
      {
        return productName;
      }

    public long getProductQuantity()
      {
        return productQuantity;
      }

    public String getProductCategory() {
      return productCategory;
    }

    public void setProductQuantity(long productQuantity) {
      this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
      return "Product{" +
              "productCategory='" + productCategory + '\'' +
              ", productName='" + productName + '\'' +
              ", productQuantity=" + productQuantity +
              ", productPrice=" + productPrice +
              '}';
    }

    public double getProductPrice()
      {
        return productPrice;
      }

    @Override
    public boolean equals(Object o)
      {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductQuantity() == product.getProductQuantity() && Double.compare(product.getProductPrice(), getProductPrice()) == 0 && Objects.equals(getProductName(), product.getProductName());
      }

    @Override
    public int hashCode()
      {
        return Objects.hash(getProductName(), getProductQuantity(), getProductPrice());
      }

    public ProductStatus getStatus() {
      return status;
    }

    public void setStatus(ProductStatus status) {
      this.status = status;
    }

  }
