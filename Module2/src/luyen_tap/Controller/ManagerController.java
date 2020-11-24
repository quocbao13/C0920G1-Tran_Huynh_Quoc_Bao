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
            System.out.println("1. Add new product.\n2. ...\n0. Exit");
            choseNum = new Validate().regexRequire(getScanner().nextLine());
            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    new ManagerProduct().addNewProduct();
                    break;
                }
            }
        }while (Integer.parseInt(choseNum) != 0);
    }
}
