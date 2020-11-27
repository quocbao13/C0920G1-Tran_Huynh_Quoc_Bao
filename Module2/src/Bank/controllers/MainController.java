package Bank.controllers;

import luyen_tap.Commons.Validate;
import luyen_tap.Controller.ManagerProduct;

import java.util.Scanner;

public class MainController {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void displayMainMenu() {
        String choseNum;
        do {
            System.out.println("1. Add new salary book.\n2. Delete salary book." +
                    "\n3. Show salary book.\n4. Show info customer." +
                    "\n5.Search salary book.\n6. Exit.\nEnter number:");
            choseNum = Validate.regexNum(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerSalaryBook.addNewProduct();
                    break;
                }
                case 2: {
                    ManagerSalaryBook.deleteBook();
                    break;
                }
                case 3: {
                    ManagerSalaryBook.showBook();
                    break;
                }
                case 4: {
                    ManagerCustomer.readCustomerCSV();
                    break;
                }
                case 5: {
                    ManagerSalaryBook.searchSalaryBook();
                    break;
                }
                default: {
                    System.out.println("----This number isn't exist!----");
                    break;
                }
            }
        }while (choseNum != "0");
    }
}
