package Store.Customer;

import java.util.*;

public class CustomerService {
  private PriorityQueue<Customer> customerQueue = new PriorityQueue<>();
   private Queue<CustomerDto> customerDtos = new PriorityQueue<>();
  private Map<String, Queue<CustomerDto>> cashierMap = new HashMap<>();


    public void Addcustomers(Customer customer,CustomerDto customerDto)
    {
        customerQueue.add(customer);
       customer.getProducts().forEach(product -> {
           customerDto.setProductQuantity(product.getProductQuantity());
           customerDto.setCustomerName(product.getProductName());
           customerDto.setProductName(product.getProductName());
           if ( cashierMap.containsKey(product.getProductName())) cashierMap.get(product.getProductName()).add(customerDto);
           else {
               cashierMap.put(customerDto.getProductName(),customerDtos);
           }
           System.out.println("Customer " + customerDto.getCustomerName() + "added to queue" );
       });
    }
    public void sellProduct(PriorityQueue<Customer> customerQueue, Map<String, Queue<CustomerDto>> productTOSell){
        assert customerQueue.peek() != null;
        customerQueue.peek().getProducts().forEach(product1 -> {
            CustomerDto removedCustomer;

            while(cashierMap.get(product1.getProductName()).peek()!=null) {
                removedCustomer = cashierMap.get(product1.getProductName()).poll();
                System.out.println("You have attended to " + removedCustomer
                        .getCustomerName() + " from the " + product1.getProductName() + " queue");
    }
    });
    }
}

