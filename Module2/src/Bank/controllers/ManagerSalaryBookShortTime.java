package Bank.controllers;

import Bank.commons.NotFoundProductException;
import Bank.commons.ReadAndWrite;
import Bank.commons.Validate;
import Bank.models.Customer;
import Bank.models.SalaryBookLongTime;
import Bank.models.SalaryBookNoTime;
import Bank.models.SalaryBookShortTime;
import luyen_tap.Controller.ManagerController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerSalaryBookShortTime {
    static int countId;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<SalaryBookShortTime> readSalaryBookCSV() {
        List<SalaryBookShortTime> shortTimes = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/Bank/datas/SalaryBook.csv");
        for (String[] line : lineArr) {
            if (line.length == 7) {
                SalaryBookShortTime salaryBookShortTime = new SalaryBookShortTime(line[0], line[1], line[2],
                        line[3], line[4], line[5], line[6]);
                shortTimes.add(salaryBookShortTime);
            }
        }
        return shortTimes;
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
        SalaryBookShortTime salaryBookShortTime = new SalaryBookShortTime();
        countId++;
        salaryBookShortTime.setIdSalary("STK-" + String.format("%04d", countId));
        salaryBookShortTime.setIdCustomer(choseCustomer());
        System.out.println("Enter Day open salary: ");
        salaryBookShortTime.setDayOpenSalary(Validate.regexDate(getScanner().nextLine()));
        System.out.println("Enter time begin: ");
        salaryBookShortTime.setTimeBegin(Validate.regexDate(getScanner().nextLine()));
        System.out.println("6 month or 3 month. Enter time stop: ");
        salaryBookShortTime.setTimeStop(Validate.regexShortTime(getScanner().nextLine()));
        System.out.println("Enter saving money: ");
        salaryBookShortTime.setSaveMoney(Validate.regexSaveMoney(getScanner().nextLine()));
        System.out.println("Enter salary money: ");
        salaryBookShortTime.setMoneySalary(Validate.regexNum(getScanner().nextLine()));
        String line = salaryBookShortTime.getIdSalary() + "," + salaryBookShortTime.getIdCustomer()
                + "," + salaryBookShortTime.getDayOpenSalary()
                + "," + salaryBookShortTime.getTimeBegin() + "," + salaryBookShortTime.getTimeStop()
                + "," + salaryBookShortTime.getSaveMoney()
                + "," + salaryBookShortTime.getMoneySalary();
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
        List<SalaryBookShortTime> salaryBookShortTimes = readSalaryBookCSV();
        for (SalaryBookShortTime s : salaryBookShortTimes) {
            s.showInfo();
        }
    }

    public static void deleteProductImport() {
        List<SalaryBookShortTime> salaryBookShortTimes = readSalaryBookCSV();
        displaySalaryBook();
        System.out.println("Enter name salary book, you want to delete: ");
        String idBook = getScanner().nextLine();
        boolean isHas = false;
        try {
            for (SalaryBookShortTime p : salaryBookShortTimes) {
                if (idBook.equals(p.getIdSalary())) {
                    salaryBookShortTimes.remove(p);
                    isHas = true;
                    isYesNo(salaryBookShortTimes);
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("This name isn't exist!!");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
            ManagerController.displayMainMenu();
        }
    }

    private static void isYesNo(List<SalaryBookShortTime> salaryBookShortTimes) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        List<SalaryBookNoTime> salaryBookNoTimes = ManagerSalaryBookNoTime.readSalaryBookCSV();
        List<SalaryBookLongTime> salaryBookLongTimes = ManagerSalaryBookLongTime.readSalaryBookCSV();
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
                ManagerController.displayMainMenu();
            }
        }
    }
}
