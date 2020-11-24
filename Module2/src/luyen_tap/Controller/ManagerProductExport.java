package luyen_tap.Controller;

import case_study.furama_resort.Controllers.MainController;
import luyen_tap.Commons.ReadAndWrite;
import luyen_tap.Commons.Validate;
import luyen_tap.Models.ProductExport;
import luyen_tap.Models.ProductImport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProductExport {
    int countId;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<ProductExport> readProductExportCSV() {
        List<ProductExport> productList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (line.length == 8) {
                ProductExport product = new ProductExport(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7]);
                productList.add(product);
            }
        }
        return productList;
    }

    public void setCountId() {
        List<String[]> lineArr= new ReadAndWrite().readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (countId < Integer.parseInt(line[0])) {
                countId = Integer.parseInt(line[0]);
            }
        }
    }

    public void addNewProduct() {
        setCountId();
        ProductExport productExport = new ProductExport();
        countId++;
        productExport.setId(String.valueOf(countId));
        productExport.setIdProduct("Product-Ex-"+String.format("%04d", countId));
        System.out.println("Enter name product: ");
        productExport.setNameProduct(new Validate().regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product: ");
        productExport.setPrice(new Validate().regexNum(getScanner().nextLine()));
        System.out.println("Enter number product: ");
        productExport.setNumber(new Validate().regexNum(getScanner().nextLine()));
        System.out.println("Enter brand product: ");
        productExport.setBrand(new Validate().regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product export: ");
        productExport.setPriceExport(new Validate().regexNum(getScanner().nextLine()));
        System.out.println("Enter address export: ");
        productExport.setAddressExport(new Validate().regexRequire(getScanner().nextLine()));
        String line = productExport.getId() + "," + productExport.getIdProduct() + "," + productExport.getNameProduct()
                + "," + productExport.getPrice() + "," + productExport.getNumber() + "," + productExport.getBrand()
                + "," + productExport.getPriceExport() + "," + productExport.getAddressExport();
        new ReadAndWrite().writeFile("src/luyen_tap/Datas/Products.csv", line);
    }

    public void displayProductExport() {
        List<ProductExport> productExportList = readProductExportCSV();
        if (productExportList.size() == 0){
            System.out.println("List is null!");
            return;
        }
        for (ProductExport p: productExportList) {
            p.showInfo();
        }
    }

    public void deleteProductExport() {
        List<ProductExport> productExportList = readProductExportCSV();
        displayProductExport();
        System.out.println("Enter name product, you want to delete: ");
        String nameProduct = getScanner().nextLine();
        boolean isHas = false;
        for (ProductExport p : productExportList) {
            if (nameProduct.equals(p.getNameProduct())) {
                productExportList.remove(p);
                isHas = true;
                isYesNo(productExportList);
                break;
            }
        }
        if (!isHas) {
            System.out.println("This name isn't exist!!");
        }
    }

    private void isYesNo(List<ProductExport> productExportList) {
        System.out.println("1. Yes/Other. No\nDo you sure?");
        List<ProductImport> productImportList = new ManagerProductImport().readProductImportCSV();
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
                new ReadAndWrite().writeFileInNewFile("src/luyen_tap/Datas/Products.csv", line);
                break;
            }
            default: {
                new MainController().displayMainMenu();
            }
        }
    }
}
