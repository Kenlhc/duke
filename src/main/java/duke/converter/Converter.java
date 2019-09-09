package duke.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This Converter program implements an application that
 * converts the user given date and time into a standard format
 */
public class Converter {
    /**
     * This method is used to convert the given date and time format
     * into a standard format
     * @param dateTime This is the date and time given by the user
     * @return SimpleDateFormat This returns the date given in the standard format
     * @throws ParseException catches invalid date formats
     */
    public static String dateTime(String dateTime) throws ParseException {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("d/MM/yyyy HHmm");
        Date date = simpleDateFormat1.parse(dateTime);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEE dd MMMM yyyy hh:mm a");
        return simpleDateFormat2.format(date);
    }
}
