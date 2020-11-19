package _19_string_and_regex.exersice.ValidateNameOfClass;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateName {
    public static void main(String[] args) {
        String regexName = "[CAP]\\d{4}[GHIKLM]";
        Scanner scanner = new Scanner(System.in);
        String nameClass = scanner.nextLine();
        if (Pattern.matches(regexName, nameClass)) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
}
