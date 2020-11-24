package luyen_tap.Controller;

import luyen_tap.Commons.Validate;

import java.util.Scanner;

public class ManagerController {

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static void displayMainMenu() {
        String choseNum;
        do {
            System.out.println("1. Add new product.\n2. Delete product.\n3. Show product.\n4. Search product.\n0. Exit.\nEnter number:");
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
                    ManagerProduct.addNewProduct();
                    break;
                }
                case 2: {
                    ManagerProduct.deleteProduct();
                    break;
                }
                case 3: {
                    ManagerProduct.showProduct();
                    break;
                }
                case 4: {
                    ManagerProduct.searchProduct();
                }
            }
        }while (choseNum != "0");
    }
}
