package common;


import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_NAME = "^([A-Z][a-z]*( [A-Z][a-z]*)*)";
    public static final String REGEX_PHONE = "[(090)(091)()]";
    public static String validateCustomerName(String name) {
        String message = null;
        if (!Pattern.matches(REGEX_NAME, name)) {
            message = "Not OK. Customer name invalid";
        }
        return message;
    }

}
