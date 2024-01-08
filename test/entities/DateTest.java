package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {
    Date date = new Date(12,4,2020);

    @Test
    public void setDay() {
        date.setDay(5);
        assertEquals(5,date.getDate());
    }

    @Test
    public void setMonth() {
        date.setMonth(8);
        assertEquals(8,date.getMonth());
    }

    @Test
    public void setYear() {
        date.setYear(2021);
        assertEquals(2021,date.getYear());
    }

    @Test
    public void getDate() {
        assertEquals(12,date.getDate());
    }

    @Test
    public void getMonth() {
        assertEquals(4,date.getMonth());
    }

    @Test
    public void getYear() {
        assertEquals(2020,date.getYear());
    }

    @Test
    public void testToString() {
        assertEquals("12/04/2020",date.toString());
    }

    @Test
    public void check() {
        Date date1 = new Date(12,4,2020);
        assertTrue(date.check(date1));
    }
}