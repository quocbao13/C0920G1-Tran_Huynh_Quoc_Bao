package Bank.controllers;

import Bank.commons.ReadAndWrite;
import Bank.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class ManagerCustomer {

    public static List<Customer> readCustomerCSV() {
        List<Customer> customerList = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/Bank/datas/Customer.csv");
        for (String[] line : lineArr) {
            if (line.length ==6) {
                Customer customer = new Customer(line[0], line[1], line[2],
                        line[3], line[4], line[5]);
                customerList.add(customer);
            }
        }
        return customerList;
    }

    public static void displayCustomer() {
        List<Customer> customerList = readCustomerCSV();
        for (Customer c : customerList) {
            c.showInfo();
        }
    }
}
