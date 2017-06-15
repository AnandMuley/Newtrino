package newtrino.utils;


import java.util.Date;

public interface DateConverterUtil {

    String PATTERN_DDMMYYYY = "dd-MMM-yyyy";

    Date calculateEndDate(Date startDate);

    Date calculateStartDate(Date today);

    Date toDate(String date,String pattern);

    String toString(Date source,String pattern);
}
