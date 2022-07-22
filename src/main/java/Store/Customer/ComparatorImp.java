package Store.Customer;

import java.util.Comparator;

public class ComparatorImp implements Comparator<CustomerDto> {
    @Override
    public int compare(CustomerDto o1, CustomerDto o2) {
        if (o1.getProductQuantity() < o2.getProductQuantity()) return 1;
        else if (o1.getProductQuantity() > o2.getProductQuantity()) return -1;
        else return 0;
    }
}
