package Bank.controllers;

import Bank.commons.NotFoundProductException;
import Bank.commons.ReadAndWrite;
import Bank.commons.Validate;
import Bank.models.Customer;
import Bank.models.SalaryBookLongTime;
import Bank.models.SalaryBookNoTime;
import Bank.models.SalaryBookShortTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerSalaryBookLongTime {

    static int countId;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<SalaryBookLongTime> readSalaryBookCSV() {
        List<SalaryBookLongTime> longTimes = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/Bank/datas/SalaryBook.csv");
        for (String[] line : lineArr) {
            if (line.length ==8) {
                SalaryBookLongTime salaryBookLongTime = new SalaryBookLongTime(line[0], line[1], line[2],
                        line[3], line[4], line[5], line[6], line[7]);
                longTimes.add(salaryBookLongTime);
            }
        }
        return longTimes;
    }



    public static void setCountId() {
        List<String[]> lineArr= luyen_tap.Commons.ReadAndWrite.readFile("src/Bank/datas/SalaryBook.csv");
        for (String[] line : lineArr) {
            String[] arrLine = line[0].split("-");
            if (countId < Integer.parseInt(arrLine[1])) {
                countId = Integer.parseInt(arrLine[1]);
            }
        }
    }

    public static void addNewBook() {
        setCountId();
        SalaryBookLongTime salaryBookLongTime = new SalaryBookLongTime();
        countId++;
        salaryBookLongTime.setIdSalary("STK-" + String.format("%04d", countId));
        salaryBookLongTime.setIdCustomer(choseCustomer());
        System.out.println("Enter Day open salary: ");
        salaryBookLongTime.setDayOpenSalary(Validate.regexDate(getScanner().nextLine()));
        System.out.println("Enter time begin: ");
        salaryBookLongTime.setTimeBegin(Validate.regexDate(getScanner().nextLine()));
        System.out.println("1, 3, 5, 10 year. Enter time stop: ");
        salaryBookLongTime.setTimeStop(Validate.regexLongTime(getScanner().nextLine()));
        System.out.println("Saving money must be more 100000. Enter saving money: ");
        salaryBookLongTime.setSaveMoney(Validate.regexSaveMoney(getScanner().nextLine()));
        System.out.println("Enter salary money: ");
        salaryBookLongTime.setMoneySalary(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter sale: ");
        salaryBookLongTime.setSale(Validate.regexRequire(getScanner().nextLine()));
        String line = salaryBookLongTime.getIdSalary() + "," + salaryBookLongTime.getIdCustomer()
                + "," + salaryBookLongTime.getDayOpenSalary()
                + "," + salaryBookLongTime.getTimeBegin() + "," + salaryBookLongTime.getTimeStop()
                + "," + salaryBookLongTime.getSaveMoney()
                + "," + salaryBookLongTime.getMoneySalary() + "," + salaryBookLongTime.getSale();
        luyen_tap.Commons.ReadAndWrite.writeFile("src/Bank/datas/SalaryBook.csv", line);
    }

    public static String choseCustomer() {
        List<Customer> customerList = ManagerCustomer.readCustomerCSV();
        ManagerCustomer.displayCustomer();
        System.out.println("Enter id customer, you want to delete: ");
        String idCus = Bank.commons.Validate.regexNum(getScanner().nextLine());
        while (true) {
            for (Customer c : customerList) {
                if (idCus.equals(c.getId())) {
                    return idCus;
                }
            }
            System.out.println("This id isn't exist!!");
            idCus = Bank.commons.Validate.regexNum(getScanner().nextLine());
        }

    }

    public static void displaySalaryBook() {
        List<SalaryBookLongTime> salaryBookLongTimes = readSalaryBookCSV();
        for (SalaryBookLongTime s : salaryBookLongTimes) {
            s.showInfo();
        }
    }

    public static void deleteProductImport() {
        List<SalaryBookLongTime> salaryBookLongTimes = readSalaryBookCSV();
        displaySalaryBook();
        System.out.println("Enter name salary book, you want to delete: ");
        String idBook = getScanner().nextLine();
        boolean isHas = false;
        try {
            for (SalaryBookLongTime p : salaryBookLongTimes) {
                if (idBook.equals(p.getIdSalary())) {
                    salaryBookLongTimes.remove(p);
                    isHas = true;
                    isYesNo(salaryBookLongTimes);
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("This name isn't exist!!");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
            MainController.displayMainMenu();
        }
    }

    private static void isYesNo(List<SalaryBookLongTime> salaryBookLongTimes) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        List<SalaryBookShortTime> salaryBookShortTimes = ManagerSalaryBookShortTime.readSalaryBookCSV();
        List<SalaryBookNoTime> salaryBookNoTimes = ManagerSalaryBookNoTime.readSalaryBookCSV();
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                String line = "";
                for (SalaryBookLongTime salaryBookLongTime: salaryBookLongTimes) {
                    line += salaryBookLongTime.getIdSalary() + "," + salaryBookLongTime.getIdCustomer()
                            + "," + salaryBookLongTime.getDayOpenSalary()
                            + "," + salaryBookLongTime.getTimeBegin() + "," + salaryBookLongTime.getTimeStop()
                            + "," + salaryBookLongTime.getSaveMoney()
                            + "," + salaryBookLongTime.getMoneySalary() + "," + salaryBookLongTime.getSale() + "\n";
                }
                for (SalaryBookShortTime salaryBookShortTime: salaryBookShortTimes) {
                    line += salaryBookShortTime.getIdSalary() + "," + salaryBookShortTime.getIdCustomer()
                            + "," + salaryBookShortTime.getDayOpenSalary()
                            + "," + salaryBookShortTime.getTimeBegin() + "," + salaryBookShortTime.getTimeStop()
                            + "," + salaryBookShortTime.getSaveMoney()
                            + "," + salaryBookShortTime.getMoneySalary() + "\n";
                }
                for (SalaryBookNoTime salaryBookNoTime: salaryBookNoTimes) {
                    line += salaryBookNoTime.getIdSalary()
                            + "," + salaryBookNoTime.getIdCustomer()
                            + "," + salaryBookNoTime.getDayOpenSalary()
                            + "," + salaryBookNoTime.getTimeBegin()
                            + "," + salaryBookNoTime.getSaveMoney()
                            + "," + salaryBookNoTime.getMoneySalary() + "\n";
                }

                luyen_tap.Commons.ReadAndWrite.writeFileInNewFile("src/Bank/datas/SalaryBook.csv", line);
                break;
            }
            default: {
                MainController.displayMainMenu();
            }
        }
    }
}
