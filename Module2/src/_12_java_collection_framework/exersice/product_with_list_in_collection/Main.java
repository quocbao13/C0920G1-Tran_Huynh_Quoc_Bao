package _12_java_collection_framework.exersice.product_with_list_in_collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isStop = true;
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        while (isStop){
            String a;
            System.out.println("1. Create a product.");
            System.out.println("2. Upload a product.");
            System.out.println("3. Delete a product.");
            System.out.println("4. Show product list.");
            System.out.println("5. Search products.");
            System.out.println("6. Reverse product by price.");
            System.out.println("0. Stop");
            System.out.println("Enter a number to execute: ");
            a = scanner.nextLine();
            boolean isNumber= true;
            for (int i = 0; i < a.length(); i++) {
                if (Character.isLetter(a.charAt(i))) {
                    System.out.println("Not a Number");
                    isNumber = false;
                    break;
                }
            }
            if (!isNumber){
                System.out.println("You enter fail. Enter to enter a different number.");
                scanner.nextLine();
                continue;
            }
            isStop = choseMenu(isStop, productManager, a);
        }
    }

    private static boolean choseMenu(boolean isStop, ProductManager productManager, String a) {
        switch (Integer.parseInt(a)){
            case 1: {
                productManager.createProduct();
                break;
            }
            case 2: {
                productManager.uploadProduct();
                break;
            }
            case 3: {
                productManager.deleteProduct();
                break;
            }
            case 4: {
                productManager.displayProduct();
                break;
            }
            case 5: {
                productManager.searchProduct();
                break;
            }
            case 6: {
                productManager.getSort();
                break;
            }
            case 0: isStop = false;
            break;
        }
        return isStop;
    }
}
