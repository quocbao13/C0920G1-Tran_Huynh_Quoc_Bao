package case_study.furama_resort.Libs.Sort;

import case_study.furama_resort.Models.Customer;
import case_study.furama_resort.Models.Services;

import java.util.Comparator;

public class NameComparator implements Comparator<Customer> {

    @Override
    public int compare(Customer c1, Customer c2) {
        if (c1.getNameCustomer().compareTo(c2.getNameCustomer()) == 0) {
            return new AgeComparator().compare(c1,c2);
        }
        return c1.getNameCustomer().compareTo(c2.getNameCustomer());
    }
}
