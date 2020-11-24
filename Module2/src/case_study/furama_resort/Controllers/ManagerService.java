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
                    + "\n0. Exit."
                    + "\nEnter number:");

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
                case 0: {
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
                    + "\n8. Exit."
                    + "\nEnter number:");
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

    public void searchService() {
        boolean isStop = true;
        while (isStop) {
            System.out.println("1. Search Villa."
                    + "\n2. Search House."
                    + "\n3. Search Room."
                    + "\n4. Back to menu."
                    + "\n0. Exit."
                    + "\nEnter number:");

            String choseNum = getScanner().nextLine();

            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    new ManagerVilla().searchVilla();
                    break;
                }
                case 2: {
                    new ManagerHouse().searchHouse();
                    break;
                }
                case 3: {
                    new ManagerRoom().searchRoom();
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

    public void editService() {
        boolean isStop = true;
        while (isStop) {
            System.out.println("1. Edit Villa."
                    + "\n2. Edit House."
                    + "\n3. Edit Room."
                    + "\n4. Back to menu."
                    + "\n0. Exit."
                    + "\nEnter number:");

            String choseNum = getScanner().nextLine();

            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    new ManagerVilla().editVilla();
                    break;
                }
                case 2: {
                    new ManagerHouse().editHouse();
                    break;
                }
                case 3: {
                    new ManagerRoom().editRoom();
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
    public void deleteService() {
        boolean isStop = true;
        while (isStop) {
            System.out.println("1. Delete Villa."
                    + "\n2. Delete House."
                    + "\n3. Delete Room."
                    + "\n4. Back to menu."
                    + "\n0. Exit."
                    + "\nEnter number:");

            String choseNum = getScanner().nextLine();

            switch (Integer.parseInt(choseNum)) {
                case 1: {
                    new ManagerVilla().deleteVilla();
                    break;
                }
                case 2: {
                    new ManagerHouse().deleteHouse();
                    break;
                }
                case 3: {
                    new ManagerRoom().deleteHouse();
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
}
