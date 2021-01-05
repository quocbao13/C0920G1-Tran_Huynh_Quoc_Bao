package thuchanh.services;

import org.springframework.stereotype.Service;
import thuchanh.models.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private Customer customer = null;
    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "A"));
        customerList.add(new Customer(2, "B"));
        customerList.add(new Customer(3, "C"));
    }

    public Customer findOne(int id) {
        for (Customer c: customerList){
            if (c.getId() == id){
                return c;
            }
        }
        return customer;
    }

    public List<Customer> selectAll() {
        return customerList;
    }

    public void save(Customer customer) {
        customerList.add(customer);
    }

    public void update(Customer customer) {
        for (Customer c : customerList) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
            }
        }
    }
}
