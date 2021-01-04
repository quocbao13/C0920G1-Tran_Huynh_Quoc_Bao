package common;


import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_NAME = "^([A-Z][a-z]*( [A-Z][a-z]*)*)";
    public static final String REGEX_PHONE = "[(090)(091)(\\(84\\)\\+90)(\\(84\\)\\+91)]\\d{7}";
    public static final String REGEX_EMAIL = "[\\w]+@[\\w]+(.[a-z]{2,4})+";

    public static String validateCustomerName(String name) {
        String message = null;
        if (!Pattern.matches(REGEX_NAME, name)) {
            message = "Not OK. Customer name invalid";
        }
        return message;
    }

    public static String validateCustomerPhone(String phone) {
        String message = null;
        if (!Pattern.matches(REGEX_PHONE, phone)) {
            message = "Not OK. Customer phone invalid";
        }
        return message;
    }

    public static String validateCustomerEmail(String email) {
        String message = null;
        if (!Pattern.matches(REGEX_EMAIL, email)) {
            message = "Not OK. Customer email invalid";
        }
        return message;
    }
}
