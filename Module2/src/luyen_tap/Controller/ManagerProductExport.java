package luyen_tap.Controller;

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
}
