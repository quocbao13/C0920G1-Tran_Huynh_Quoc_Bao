package case_study.furama_resort.Views;

import case_study.furama_resort.Controllers.MainController;

public class Main {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.readVillaCSV();
        mainController.readHouseCSV();
        mainController.readRoomCSV();
        mainController.readCustomerCSV();
        mainController.displayMainMenu();
    }
}
