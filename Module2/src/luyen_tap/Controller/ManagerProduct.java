package luyen_tap.Controller;

import case_study.furama_resort.Models.Villa;
import luyen_tap.Commons.ReadAndWrite;
import luyen_tap.Commons.Validate;
import luyen_tap.Models.Product;
import luyen_tap.Models.ProductExport;
import luyen_tap.Models.ProductImport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<Product> readProductCSV() {
        List<Product> productList = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (line.length == 9) {
                Product product = new ProductImport(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                productList.add(product);
            }else {
                Product product = new ProductExport(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
                productList.add(product);
            }
        }
        return productList;
    }

    public static void addNewProduct() {
        String choseNum;
        do {
            System.out.println("1. Add new product import.\n2. Add new product export.\n3. Back to menu.\n0. Exit.\nEnter number:");
            choseNum = Validate.regexRequire(getScanner().nextLine());
            boolean isNumber= true;
            for (int i = 0; i < choseNum.length(); i++) {
                if (Character.isLetter(choseNum.charAt(i))) {
                    System.out.println("Not a Number");
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber){
                System.out.println("You enter fail. Enter to enter a different number.");
                continue;
            }
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerProductImport.addNewProduct();
                    break;
                }
                case 2: {
                    ManagerProductExport.addNewProduct();
                    break;
                }
                case 3: {
                    new ManagerController().displayMainMenu();
                    break;
                }
            }
        }while (choseNum != "0");
    }

    public static void showProduct() {
        String choseNum;
        do {
            System.out.println("1. Show product import.\n2. Show product export.\n3. Back to menu.\n0. Exit.\nEnter number:");
            choseNum = Validate.regexRequire(getScanner().nextLine());
            boolean isNumber= true;
            for (int i = 0; i < choseNum.length(); i++) {
                if (Character.isLetter(choseNum.charAt(i))) {
                    System.out.println("Not a Number");
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber){
                System.out.println("You enter fail. Enter to enter a different number.");
                continue;
            }
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerProductImport.displayProductImport();
                    break;
                }
                case 2: {
                    ManagerProductExport.displayProductExport();
                    break;
                }
                case 3: {
                    new ManagerController().displayMainMenu();
                    break;
                }
            }
        }while (choseNum != "0");
    }

    public static void deleteProduct() {
        String choseNum;
        do {
            System.out.println("1. Delete product import.\n2. Delete product export.\n3. Back to menu.\n0. Exit.\nEnter number:");
            choseNum = Validate.regexRequire(getScanner().nextLine());
            boolean isNumber= true;
            for (int i = 0; i < choseNum.length(); i++) {
                if (Character.isLetter(choseNum.charAt(i))) {
                    System.out.println("Not a Number");
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber){
                System.out.println("You enter fail. Enter to enter a different number.");
                continue;
            }
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    ManagerProductImport.deleteProductImport();
                    break;
                }
                case 2: {
                    ManagerProductExport.deleteProductExport();
                    break;
                }
                case 3: {
                    new ManagerController().displayMainMenu();
                    break;
                }
            }
        }while (Integer.parseInt(choseNum) != 0);
    }

    public static void searchProduct() {
        List<Product> productList = readProductCSV();
        System.out.println("Enter name product, you want to find: ");
        String nameProduct = Validate.regexRequire(getScanner().nextLine());
        boolean isHas = false;
        for (Product p : productList) {
            if (p.getNameProduct().toLowerCase().contains(nameProduct.toLowerCase())) {
                p.showInfo();
                isHas = true;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
    }
}
