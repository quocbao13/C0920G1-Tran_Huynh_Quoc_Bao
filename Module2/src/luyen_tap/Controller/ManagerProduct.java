package luyen_tap.Controller;

import luyen_tap.Commons.ReadAndWrite;
import luyen_tap.Commons.Validate;
import luyen_tap.Models.Product;
import luyen_tap.Models.ProductExport;
import luyen_tap.Models.ProductImport;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public List<Product> readProductCSV() {
        List<Product> productList = new ArrayList<>();
        List<String[]> lineArr= new ReadAndWrite().readFile("src/luyen_tap/Datas/Products.csv");
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

    public void addNewProduct() {
        String choseNum;
        do {
            System.out.println("1. Add new product import.\n2. Add new product export.\n3. Back to menu.\n0. Exit");
            choseNum = new Validate().regexRequire(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    new ManagerProductImport().addNewProduct();
                    break;
                }
                case 2: {
                    new ManagerProductExport().addNewProduct();
                    break;
                }
                case 3: {
                    new ManagerController().displayMainMenu();
                    break;
                }
            }
        }while (Integer.parseInt(choseNum) != 0);
    }
}
