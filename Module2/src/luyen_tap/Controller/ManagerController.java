package luyen_tap.Controller;

import luyen_tap.Commons.Validate;

import java.util.Scanner;

public class ManagerController {

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void displayMainMenu() {
        String choseNum;
        do {
            System.out.println("1. Add new product.\n2. Delete product\n0. Exit");
            choseNum = new Validate().regexRequire(getScanner().nextLine());
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
                    new ManagerProduct().addNewProduct();
                    break;
                }
                case 2: {
                    new ManagerProduct().deleteProduct();
                    break;
                }
            }
        }while (choseNum != "0");
    }
}
