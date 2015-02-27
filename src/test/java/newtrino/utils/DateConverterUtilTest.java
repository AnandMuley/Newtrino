package newtrino.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertTrue;

public class DateConverterUtilTest {

    private DateConverterUtil dateConverterUtil;

    @Before
    public void setUp() throws Exception {
        dateConverterUtil = new DateConverterUtilImpl();
    }

    @Test
    public void testCalculateEndDate() throws Exception {
        // Given
        Date today = new Date();

        // When
        Date actual = dateConverterUtil.calculateEndDate(today);

        // Then
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(actual);
        assertTrue(today.before(actual));
        assertTrue(calendar.get(Calendar.MINUTE)==0);
        assertTrue(calendar.get(Calendar.HOUR_OF_DAY)==0);
        assertTrue(calendar.get(Calendar.SECOND)==0);
    }

}