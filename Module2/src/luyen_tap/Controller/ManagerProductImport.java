package luyen_tap.Controller;

import luyen_tap.Commons.ReadAndWrite;
import luyen_tap.Commons.Validate;
import luyen_tap.Models.Product;
import luyen_tap.Models.ProductImport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProductImport {
    int countId;

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<ProductImport> readProductImportCSV() {
        List<ProductImport> productList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/luyen_tap/Datas/Products.csv");
        for (String[] line : lineArr) {
            if (line.length == 9) {
                ProductImport product = new ProductImport(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
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
        ProductImport productImport = new ProductImport();
        countId++;
        productImport.setId(String.valueOf(countId));
        productImport.setIdProduct("Product-Im-" + String.format("%04d", countId));
        System.out.println("Enter name product: ");
        productImport.setNameProduct(new Validate().regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product: ");
        productImport.setPrice(new Validate().regexNum(getScanner().nextLine()));
        System.out.println("Enter number product: ");
        productImport.setNumber(new Validate().regexNum(getScanner().nextLine()));
        System.out.println("Enter brand product: ");
        productImport.setBrand(new Validate().regexRequire(getScanner().nextLine()));
        System.out.println("Enter price product import: ");
        productImport.setPriceImport(new Validate().regexNum(getScanner().nextLine()));
        System.out.println("Enter address import: ");
        productImport.setAddressImport(new Validate().regexRequire(getScanner().nextLine()));
        System.out.println("Enter tax import: ");
        productImport.setTaxImport(new Validate().regexRequire(getScanner().nextLine()));
        String line = productImport.getId() + "," + productImport.getIdProduct() + "," + productImport.getNameProduct()
                + "," + productImport.getPrice() + "," + productImport.getNumber() + "," + productImport.getBrand()
                + "," + productImport.getPriceImport() + "," + productImport.getAddressImport() + "," + productImport.getTaxImport();
        new ReadAndWrite().writeFile("src/luyen_tap/Datas/Products.csv", line);
    }
}
