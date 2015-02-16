package newtrino.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DateConverterUtilTest {

    private DateConverterUtil dateConverterUtil;

    @Before
    public void setUp() throws Exception {
        dateConverterUtil = new DateConverterUtil();
    }

    @Test
    public void testCalculateEndDate() throws Exception {
        // Given
        Date today = new Date();

        // When
        Date actual = dateConverterUtil.calculateEndDate(today);

        // Then
        assertTrue(today.before(actual));
        assertTrue(actual.getMinutes()==0);
        assertTrue(actual.getHours()==0);
        assertTrue(actual.getSeconds()==0);
    }

    @After
    public void tearDown() throws Exception {

    }
}