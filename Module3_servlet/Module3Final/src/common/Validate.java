package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Validate {
    public static final String REGEX_NAME = "^([A-Z][a-z]*( [A-Z][a-z]*)*)";
    public static final String REGEX_LYDO = "^([A-Z1-9][a-z1-9.]*( [A-Za-z1-9][a-z1-9]*)*)";

    public static String validateCustomerName(String name) {
        String message = null;
        if (!Pattern.matches(REGEX_NAME, name)) {
            message = "Khong dung. Ten benh nhan khong dung dinh dang.";
        }
        return message;
    }
    public static String validateCustomerLyDo(String name) {
        String message = null;
        if (!Pattern.matches(REGEX_LYDO, name)) {
            message = "Khong dung. Ly do khong dung dinh dang.";
        }
        return message;
    }

    public static String vaLiDateDate(String date1, String date2) {
        String message = null;
        long currentTime = System.currentTimeMillis();
        Date date1n = null;
        Date date2n = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date1n = simpleDateFormat.parse(date1);
            date2n = simpleDateFormat.parse(date2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date1n != null;
        assert date2n != null;
        long millisecondsBirth1 =  date1n.getTime();
        long millisecondsBirth2 =  date2n.getTime();
        long millisecondsAge1 = currentTime - millisecondsBirth1;
        long millisecondsAge2 = currentTime - millisecondsBirth2;
        long rateMilliToYear = 60*60*24*365;
        long dateVao1 = millisecondsAge1 / (rateMilliToYear * 1000);
        long dateVao2 = millisecondsAge2 / (rateMilliToYear * 1000);
        boolean a = dateVao2 - dateVao1 < 0;
        if (a) {
            message = "Ngay ra phai lon hon ngay vao";
        }
        return message;
    }
}
