package newtrino.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateConverterUtilImpl implements DateConverterUtil{

    @Override
    public Date calculateEndDate(Date startDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    @Override
    public Date calculateStartDate(Date today){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        return calendar.getTime();
    }

    @Override
    public Date toDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date dateObj = null;
        try {
            dateObj = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateObj;
    }

    @Override
    public String toString(Date source, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(source);
    }

}
