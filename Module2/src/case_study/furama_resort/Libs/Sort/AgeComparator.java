package case_study.furama_resort.Libs.Sort;

import case_study.furama_resort.Models.Customer;
import case_study.furama_resort.Models.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.SimpleTimeZone;

public class AgeComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer c1, Customer c2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = simpleDateFormat.parse(c1.getBirthDayCustomer());
            date2 = simpleDateFormat.parse(c2.getBirthDayCustomer());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date2 != null;
        return date1.compareTo(date2);
    }
}
