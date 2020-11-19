package _17_io_binary_file_and_serializatioin.exersice.manager_product_save_to_binary_file;

import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    public void displayMainMenu() {
        System.out.println("1. Add new product." +
                "\n2. Show product." +
                "\n3. Search product." +
                "\nEnter a number: ");
        switch (Integer.parseInt(scanner.nextLine())){
            case 1: {
                addNewProduct();
                break;
            }
            case 2: {
                showProduct();
                break;
            }
            case 3: {
                break;
            }

        }
    }

    public void addNewProduct() {
        Product product = new Product();
        System.out.println("Enter id product: ");
        product.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter name product: ");
        product.setName(scanner.nextLine());
        System.out.println("Enter brand product: ");
        product.setBrand(scanner.nextLine());
        System.out.println("Enter price product: ");
        product.setPrice(scanner.nextDouble());
        scanner.nextLine();
        System.out.println("Enter status different: ");
        product.setStatusDifferent(scanner.nextLine());
        new WriterAndReader().writeFile(product);
    }

    public void showProduct() {
        new WriterAndReader().readFile();
//        for (Product p : productList) {
//            System.out.println(p.toString());
//        }
    }
}
