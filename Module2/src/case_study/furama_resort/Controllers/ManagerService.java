package case_study.furama_resort.Controllers;

import java.util.Scanner;

public class ManagerService {
    public void addNewService() {
        boolean isStop = true;
        while (isStop) {
            System.out.println("1. Add New Villa."
                    + "\n2. Add New House."
                    + "\n3. Add New Room."
                    + "\n4. Back to menu."
                    + "\n5. Exit."
                    + "Enter number.");

            String choseNum = getScanner().nextLine();

            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    new ManagerVilla().addNewVilla();
                    break;
                }
                case 2: {
                    new ManagerHouse().addNewHouse();
                    break;
                }
                case 3: {
                    new ManagerRoom().addNewRoom();
                    break;
                }
                case 4: {
                    new MainController().displayMainMenu();
                    break;
                }
                case 5: {
                    isStop = false;
                    break;
                }
            }
        }
    }

    private Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void displayService() {
        boolean isStop = true;
        while (isStop){
            System.out.println("1. Show all Villa."
                    + "\n2. Show all House."
                    + "\n3. Show all Room."
                    + "\n4. Show All Name Villa Not Duplicate."
                    + "\n5. Show All Name House Not Duplicate."
                    + "\n6. Show All Name Room Not Duplicate."
                    + "\n7. Back to menu."
                    + "\n8. Exit.");
            String numChose = getScanner().nextLine();
            switch (Integer.parseInt(numChose)){
                case 1: {
                    new ManagerVilla().displayVilla();
                    break;
                }
                case 2: {
                    new ManagerHouse().displayHouse();
                    break;
                }
                case 3: {
                    new ManagerRoom().displayRoom();
                    break;
                }
                case 4: {
                    new ManagerVilla().displayVillaDuplicate();
                    break;
                }
                case 5: {
                    new ManagerHouse().displayHouseDuplicate();
                    break;
                }
                case 6: {
                    new ManagerRoom().displayRoomDuplicate();
                    break;
                }
                case 7: {
                    new MainController().displayMainMenu();
                    break;
                }
                case 8: {
                    isStop = false;
                    break;
                }

            }
        }
    }
}
