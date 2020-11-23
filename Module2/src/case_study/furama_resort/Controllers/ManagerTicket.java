package case_study.furama_resort.Controllers;

import case_study.furama_resort.Models.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ManagerTicket {
    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void bookingTicket() {
        Queue<Customer> customerQueue = new LinkedList<>();
        int count;
        System.out.println("Enter sum tickets in today: ");
        count = getScanner().nextByte();
        for (int i = 1; i <= count; ) {
            new ManagerCustomer().showCustomer();
            System.out.println("Enter name customer: ");
            String name = getScanner().nextLine();
            List<Customer> customerList = new ManagerCustomer().readCustomerCSV();
            boolean isHas = false;
            for (Customer c: customerList) {
                if (name.equals(c.getNameCustomer())){
                    customerQueue.add(c);
                    isHas = true;
                    i++;
                    break;
                }
            }
            if (!isHas) {
                System.out.println("This customer isn't register.\n1. Enter different name \nOther. Stop");
                if (Integer.parseInt(getScanner().nextLine()) == 1){
                    continue;
                }else {
                    break;
                }
            }
        }

        for (Customer c : customerQueue) {
            System.out.println(c.getNameCustomer());
        }
    }
}
