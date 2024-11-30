import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class CalendarJava{


    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
        String date = dateFormat.format(new Date());
        return date;

    }


    public static void main(String[] args) {
        System.out.println(CalendarJava.getCurrentDate());
    }
}
