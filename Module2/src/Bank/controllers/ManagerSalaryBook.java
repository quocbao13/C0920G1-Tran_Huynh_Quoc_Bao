package Bank.controllers;


import Bank.commons.ReadAndWrite;
import Bank.commons.Validate;
import Bank.models.SalaryBook;
import Bank.models.SalaryBookLongTime;
import Bank.models.SalaryBookNoTime;
import Bank.models.SalaryBookShortTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerSalaryBook {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<SalaryBook> readBookCSV() {
        List<SalaryBook> productList = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/Bank/datas/SalaryBook.csv");
        for (String[] line : lineArr) {
            if (line.length == 8) {
                SalaryBook salaryBook = new SalaryBookLongTime(line[0], line[1], line[2], line[3],
                        line[4], line[5], line[6], line[7]);
                productList.add(salaryBook);
            }else if (line.length == 7){
                SalaryBook salaryBook = new SalaryBookShortTime(line[0], line[1], line[2], line[3],
                        line[4], line[5], line[6]);
                productList.add(salaryBook);
            }else {
                SalaryBook salaryBook = new SalaryBookNoTime(line[0], line[1], line[2], line[3],
                        line[4], line[5]);
                productList.add(salaryBook);
            }
        }
        return productList;
    }

    public static void addNewProduct() {
        String choseNum;
        do {
            System.out.println("1. Add new salary book long time." +
                    "\n2. Add new salary book short time." +
                    "\n3. Back to menu." +
                    "\n0. Exit.\nEnter number:");
            choseNum = Validate.regexNum(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerSalaryBookLongTime.addNewBook();
                    break;
                }
                case 2: {
                    choseShortOrNoTime();
                    break;
                }
                case 3: {
                    MainController.displayMainMenu();
                    break;
                }
                default: {
                    System.out.println("----This number isn't exist!----");
                }
            }
        }while (choseNum != "0");
    }

    public static void deleteBook() {
        String choseNum;
        do {
            System.out.println("1. Delete salary book long time." +
                    "\n2. Delete salary book short time." +
                    "\n3. Delete salary book no time." +
                    "\n4. Back to menu." +
                    "\n0. Exit.\nEnter number:");
            choseNum = Validate.regexNum(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerSalaryBookLongTime.deleteProductImport();
                    break;
                }
                case 2: {
                    ManagerSalaryBookShortTime.deleteProductImport();
                    break;
                }
                case 3: {
                    ManagerSalaryBookNoTime.deleteProductImport();
                    break;
                }
                case 4: {
                    MainController.displayMainMenu();
                    break;
                }
                default: {
                    System.out.println("----This number isn't exist!----");
                }
            }
        }while (choseNum != "0");
    }

    public static void showBook() {
        String choseNum;
        do {
            System.out.println("1. Show salary book long time." +
                    "\n2. Show salary book short time." +
                    "\n3. Show salary book no time." +
                    "\n4. Back to menu." +
                    "\n0. Exit.\nEnter number:");
            choseNum = Validate.regexNum(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerSalaryBookLongTime.displaySalaryBook();
                    break;
                }
                case 2: {
                    ManagerSalaryBookShortTime.displaySalaryBook();
                    break;
                }
                case 3: {
                    ManagerSalaryBookNoTime.displaySalaryBook();
                    break;
                }
                case 4: {
                    MainController.displayMainMenu();
                    break;
                }
                default: {
                    System.out.println("----This number isn't exist!----");
                }
            }
        }while (choseNum != "0");
    }

    public static void choseShortOrNoTime() {
        String choseNum;
        do {
            System.out.println("1. Add new salary book short time." +
                    "\n2. Add new salary book no time." +
                    "\n3. Back to menu." +
                    "\n0. Exit.\nEnter number:");
            choseNum = Validate.regexNum(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerSalaryBookShortTime.addNewBook();
                    break;
                }
                case 2: {
                    ManagerSalaryBookNoTime.addNewBook();
                    break;
                }
                case 3: {
                    MainController.displayMainMenu();
                }
                default: {
                    System.out.println("----This number isn't exist!----");
                }
            }
        }while (choseNum != "0");
    }

    public static void searchSalaryBook() {
        List<SalaryBook> salaryBooks = readBookCSV();
        System.out.println("Enter name product, you want to find: ");
        String idSalaryBook = Validate.regexRequire(getScanner().nextLine());
        boolean isHas = false;
        for (SalaryBook p : salaryBooks) {
            if (p.getIdCustomer().toLowerCase().contains(idSalaryBook.toLowerCase())) {
                p.showInfo();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
    }
}
