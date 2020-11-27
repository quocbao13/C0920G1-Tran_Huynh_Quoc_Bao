package luyen_tap.Commons;

import luyen_tap.Controller.ManagerController;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_REQUIRE = "[\\w ]+";
    public static final String REGEX_NUM = "[\\d]+";

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static String regexRequire(String str) {
        while (true){
            if (Pattern.matches(REGEX_REQUIRE, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            } else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }

    public static String regexNum(String str) {
        while (true){
            if (Pattern.matches(REGEX_NUM, str)) {
                return str;
            }else if (str.equals("null")) {
                ManagerController.displayMainMenu();
            }else {
                System.out.println("Fail. Enter \"null\" to exit or Enter again: ");
                str = getScanner().nextLine();
            }
        }
    }
}
