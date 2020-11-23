package case_study.furama_resort.Controllers;

import case_study.furama_resort.Commons.ReadAndWrite;
import case_study.furama_resort.Commons.Validate;
import case_study.furama_resort.Commons.ValidateCustomer;
import case_study.furama_resort.Libs.Sort.NameComparator;
import case_study.furama_resort.Models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerCustomer {
    public static int countIdCustomer;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<Customer> readCustomerCSV() {
        List<Customer> customerList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Customer.csv");
        for (String[] line : lineArr) {
            Customer customer = new Customer(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
            customerList.add(customer);
        }
        return customerList;
    }

    public void setCountId() {
        List<String[]> lineArr= new ReadAndWrite().readFile("src/case_study/furama_resort/Data/Customer.csv");
        for (String[] line : lineArr) {
            if (countIdCustomer < Integer.parseInt(line[0])) {
                countIdCustomer = Integer.parseInt(line[0]);
            }
        }
    }

    public void addNewCustomer() {
        setCountId();
        Customer customer = new Customer();
        countIdCustomer++;
        customer.setIdCustomer(String.valueOf(countIdCustomer));
        System.out.println("Enter name customer: ");
        customer.setNameCustomer(new Validate().regexName(getScanner().nextLine()));
        System.out.println("Enter birthday customer: ");
        customer.setBirthDayCustomer(new ValidateCustomer().regexDate(getScanner().nextLine()));
        System.out.println("Enter gender customer: ");
        customer.setGenderCustomer(getScanner().nextLine());
        System.out.println("Enter id number customer: ");
        customer.setIdNumberCustomer(getScanner().nextLine());
        System.out.println("Enter phone customer: ");
        customer.setPhoneCustomer(getScanner().nextLine());
        System.out.println("Enter email customer: ");
        customer.setEmailCustomer(new ValidateCustomer().regexEmail(getScanner().nextLine()));
        System.out.println("Enter type customer: ");
        customer.setTypeOfCustomer(getScanner().nextLine());
        System.out.println("Enter address customer: ");
        customer.setAddressCustomer(getScanner().nextLine());
        String line = customer.getIdCustomer() + "," + customer.getNameCustomer() + "," + customer.getBirthDayCustomer() + "," + customer.getGenderCustomer()
                        + "," + customer.getIdNumberCustomer() + "," + customer.getPhoneCustomer() + "," + customer.getEmailCustomer()
                        + "," + customer.getTypeOfCustomer() + "," + customer.getAddressCustomer();
        new ReadAndWrite().writeFile("src/case_study/furama_resort/Data/Customer.csv", line);
    }

    public void showCustomer() {
        List<Customer> customerList = readCustomerCSV();
        customerList.sort(new NameComparator());
        int count = 0;
        for (Customer c: customerList) {
            count++;
            System.out.print(count + ": ");
            c.showInfo();
        }
    }
}
