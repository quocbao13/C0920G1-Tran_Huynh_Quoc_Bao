package Bank.controllers;

import Bank.commons.ReadAndWrite;
import Bank.commons.Validate;
import Bank.models.Customer;
import Bank.models.SalaryBookLongTime;
import Bank.models.SalaryBookNoTime;
import Bank.models.SalaryBookShortTime;
import luyen_tap.Commons.NotFoundProductException;
import luyen_tap.Controller.ManagerController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerSalaryBookNoTime {
    static int countId;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<SalaryBookNoTime> readSalaryBookCSV() {
        List<SalaryBookNoTime> noTimes = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/Bank/datas/SalaryBook.csv");
        for (String[] line : lineArr) {
            if (line.length == 6) {
                SalaryBookNoTime salaryBookNoTime = new SalaryBookNoTime(line[0], line[1], line[2], line[3], line[4], line[5]);
                noTimes.add(salaryBookNoTime);
            }
        }
        return noTimes;
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
        SalaryBookNoTime salaryBookNoTime = new SalaryBookNoTime();
        countId++;
        salaryBookNoTime.setIdSalary("STK-" + String.format("%04d", countId));
        salaryBookNoTime.setIdCustomer(choseCustomer());
        System.out.println("Enter Day open salary: ");
        salaryBookNoTime.setDayOpenSalary(Validate.regexDate(getScanner().nextLine()));
        System.out.println("Enter time begin: ");
        salaryBookNoTime.setTimeBegin(Validate.regexDate(getScanner().nextLine()));
        System.out.println("Enter saving money: ");
        salaryBookNoTime.setSaveMoney(Validate.regexSaveMoney(getScanner().nextLine()));
        System.out.println("Enter salary money: ");
        salaryBookNoTime.setMoneySalary(Validate.regexNum(getScanner().nextLine()));
        String line = salaryBookNoTime.getIdSalary()
                + "," + salaryBookNoTime.getIdCustomer()
                + "," + salaryBookNoTime.getDayOpenSalary()
                + "," + salaryBookNoTime.getTimeBegin()
                + "," + salaryBookNoTime.getSaveMoney()
                + "," + salaryBookNoTime.getMoneySalary();
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
        List<SalaryBookNoTime> salaryBookNoTimes = readSalaryBookCSV();
        for (SalaryBookNoTime s : salaryBookNoTimes) {
            s.showInfo();
        }
    }

    public static void deleteProductImport() {
        List<SalaryBookNoTime> salaryBookNoTimes = readSalaryBookCSV();
        displaySalaryBook();
        System.out.println("Enter name salary book, you want to delete: ");
        String idBook = getScanner().nextLine();
        boolean isHas = false;
        try {
            for (SalaryBookNoTime p : salaryBookNoTimes) {
                if (idBook.equals(p.getIdSalary())) {
                    salaryBookNoTimes.remove(p);
                    isHas = true;
                    isYesNo(salaryBookNoTimes);
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

    private static void isYesNo(List<SalaryBookNoTime> salaryBookNoTimes) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        List<SalaryBookShortTime> salaryBookShortTimes = ManagerSalaryBookShortTime.readSalaryBookCSV();
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
