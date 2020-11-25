package luyen_tap.Controller;

import case_study.furama_resort.Controllers.MainController;
import luyen_tap.Commons.NotFoundProductException;
import luyen_tap.Commons.ReadAndWrite;
import luyen_tap.Commons.Validate;
import luyen_tap.Models.ProductExport;
import luyen_tap.Models.ProductImport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProductExport {
    static int countId;

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static List<ProductExport> readProductExportCSV() {
        List<ProductExport> productList = new ArrayList<>();
        List<String[]> lineArr= ReadAndWrite.readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (line.length == 8) {
                ProductExport product = new ProductExport(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
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
        ProductExport productExport = new ProductExport();
        countId++;
        productExport.setId(String.valueOf(countId));
        productExport.setIdProduct("Product-Ex-"+String.format("%04d", countId));
        System.out.println("Enter name product: ");
        productExport.setNameProduct(Validate.regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product: ");
        productExport.setPrice(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter number product: ");
        productExport.setNumber(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter brand product: ");
        productExport.setBrand(Validate.regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product export: ");
        productExport.setPriceExport(Validate.regexNum(getScanner().nextLine()));
        System.out.println("Enter address export: ");
        productExport.setAddressExport(Validate.regexRequire(getScanner().nextLine()));
        String line = productExport.getId() + "," + productExport.getIdProduct() + "," + productExport.getNameProduct()
                + "," + productExport.getPrice() + "," + productExport.getNumber() + "," + productExport.getBrand()
                + "," + productExport.getPriceExport() + "," + productExport.getAddressExport();
        ReadAndWrite.writeFile("src/luyen_tap/Datas/Products.csv", line);
    }

    public static void displayProductExport() {
        List<ProductExport> productExportList = readProductExportCSV();
        if (productExportList.size() == 0){
            System.out.println("List is null!");
            return;
        }
        for (ProductExport p: productExportList) {
            p.showInfo();
        }
    }

    public static void editProductExport() {
        List<ProductExport> productExportList = readProductExportCSV();
        displayProductExport();
        System.out.println("Enter id card product, you want to edit: ");
        String idProduct = getScanner().nextLine();
        boolean isHas = false;
        try {
            for (ProductExport p : productExportList) {
                if (idProduct.equals(p.getIdProduct())) {
                    chosePropertyToEdit(p);
                    isHas = true;
                    isYesNo(productExportList);
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

    public static void deleteProductExport() {
        List<ProductExport> productExportList = readProductExportCSV();
        displayProductExport();
        System.out.println("Enter name product, you want to delete: ");
        String nameProduct = getScanner().nextLine();
        boolean isHas = false;
        try {
            for (ProductExport p : productExportList) {
                if (nameProduct.equals(p.getNameProduct())) {
                    productExportList.remove(p);
                    isHas = true;
                    isYesNo(productExportList);
                    break;
                }
            }
            if (!isHas) {
                throw new NotFoundProductException("This name isn't exist!!");
            }
        } catch (NotFoundProductException e) {
            e.printStackTrace();
        }
    }

    private static void chosePropertyToEdit(ProductExport productExport) {
        choseHeader();
        switch (Integer.parseInt(Validate.regexNum(getScanner().nextLine()))) {
            case 1: {
                System.out.println("Enter new name product: ");
                productExport.setNameProduct(Validate.regexRequire(getScanner().nextLine()));
                break;
            }
            case 2: {
                System.out.println("Enter price product: ");
                productExport.setPrice(Validate.regexNum(getScanner().nextLine()));
                break;
            }
            case 3: {
                System.out.println("Enter new number product: ");
                productExport.setNumber(Validate.regexNum(getScanner().nextLine()));
                break;
            }
            case 4: {
                System.out.println("Enter new brand product: ");
                productExport.setBrand(Validate.regexRequire(getScanner().nextLine()));
                break;
            }
            case 5: {
                System.out.println("Enter price import product: ");
                productExport.setPriceExport(Validate.regexNum(getScanner().nextLine()));
                break;
            }
            case 6: {
                System.out.println("Enter address import: ");
                productExport.setAddressExport(Validate.regexRequire(getScanner().nextLine()));
                break;
            }
            case 7: {
                ManagerController.displayMainMenu();
                break;
            }
            default: {
                chosePropertyToEdit(productExport);
            }
        }
    }

    private static void choseHeader() {
        System.out.println("1. Name product." +
                "\n2. Price product." +
                "\n3. Number product." +
                "\n4. Brand product." +
                "\n5. Price import product." +
                "\n6. Address import." +
                "\n7. Cancel edit." +
                "\nEnter number: ");
    }

    private static void isYesNo(List<ProductExport> productExportList) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        List<ProductImport> productImportList = ManagerProductImport.readProductImportCSV();
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
