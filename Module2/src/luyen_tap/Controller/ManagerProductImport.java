package luyen_tap.Controller;

import case_study.furama_resort.Controllers.MainController;
import case_study.furama_resort.Models.Villa;
import luyen_tap.Commons.NotFoundProductException;
import luyen_tap.Commons.ReadAndWrite;
import luyen_tap.Commons.Validate;
import luyen_tap.Models.Product;
import luyen_tap.Models.ProductExport;
import luyen_tap.Models.ProductImport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProductImport {
    static int countId;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<ProductImport> readProductImportCSV() {
        List<ProductImport> productList = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (line.length == 9) {
                ProductImport product = new ProductImport(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                productList.add(product);
            }
        }
        return productList;
    }

    public static void setCountId() {
        List<String[]> lineArr= ReadAndWrite.readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (countId < Integer.parseInt(line[0])) {
                countId = Integer.parseInt(line[0]);
            }
        }
    }

    public static void addNewProduct() {
        setCountId();
        ProductImport productImport = new ProductImport();
        countId++;
        productImport.setId(String.valueOf(countId));
        productImport.setIdProduct("Product-Im-" + String.format("%04d", countId));
        System.out.println("Enter name product: ");
        productImport.setNameProduct(Validate.regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product: ");
        productImport.setPrice(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter number product: ");
        productImport.setNumber(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter brand product: ");
        productImport.setBrand(Validate.regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product import: ");
        productImport.setPriceImport(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter address import: ");
        productImport.setAddressImport(Validate.regexRequire(getScanner().nextLine()));
        System.out.println("Enter tax import: ");
        productImport.setTaxImport(Validate.regexRequire(getScanner().nextLine()));
        String line = productImport.getId() + "," + productImport.getIdProduct() + "," + productImport.getNameProduct()
                + "," + productImport.getPrice() + "," + productImport.getNumber() + "," + productImport.getBrand()
                + "," + productImport.getPriceImport() + "," + productImport.getAddressImport() + "," + productImport.getTaxImport();
        ReadAndWrite.writeFile("src/luyen_tap/Datas/Products.csv", line);
    }

    public static void displayProductImport() {
        List<ProductImport> productImportList = readProductImportCSV();
        if (productImportList.size() == 0){
            System.out.println("List is null!");
            return;
        }
        for (ProductImport p: productImportList) {
            p.showInfo();
        }
    }

    public static void deleteProductImport() {
        List<ProductImport> productImportList = readProductImportCSV();
        displayProductImport();
        System.out.println("Enter name product, you want to delete: ");
        String nameProduct = getScanner().nextLine();
        boolean isHas = false;
        try {
            for (ProductImport p : productImportList) {
                if (nameProduct.equals(p.getNameProduct())) {
                    productImportList.remove(p);
                    isHas = true;
                    isYesNo(productImportList);
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

    private static void isYesNo(List<ProductImport> productImportList) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        List<ProductExport> productExportList = ManagerProductExport.readProductExportCSV();
        switch (Integer.parseInt(getScanner().nextLine())) {
            case 1: {
                String line = "";
                for (ProductImport productImport: productImportList) {
                    line += productImport.getId() + "," + productImport.getIdProduct() + "," + productImport.getNameProduct()
                            + "," + productImport.getPrice() + "," + productImport.getNumber() + "," + productImport.getBrand()
                            + "," + productImport.getPriceImport() + "," + productImport.getAddressImport() + "," + productImport.getTaxImport() + "\n";
                }
                for (ProductExport productExport: productExportList) {
                    line += productExport.getId() + "," + productExport.getIdProduct() + "," + productExport.getNameProduct()
                            + "," + productExport.getPrice() + "," + productExport.getNumber() + "," + productExport.getBrand()
                            + "," + productExport.getPriceExport() + "," + productExport.getAddressExport() + "\n";
                }
                ReadAndWrite.writeFileInNewFile("src/luyen_tap/Datas/Products.csv", line);
                break;
            }
            default: {
                new MainController().displayMainMenu();
            }
        }
    }
}
