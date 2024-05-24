package br.pucrs.bruno.laitano;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NextDateTest {
    private NextDate nd;
    
    @Test
    void sizeValidationTest() {
        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.sizeValidation());

        nd = new NextDate("14/4/1997");
        assertEquals(false, nd.sizeValidation());

        nd = new NextDate("144/04/1997");
        assertEquals(false, nd.sizeValidation());
    }

    @Test
    void digitsValidationTest() {
        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.digitsValidation());

        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.digitsValidation());

        nd = new NextDate("D4/04/1997");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("1D/04/1997");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("14/D4/1997");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("14/0D/1997");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("14/04/D997");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("14/04/1D97");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("14/04/19D7");
        assertEquals(false, nd.digitsValidation());

        nd = new NextDate("14/04/199D");
        assertEquals(false, nd.digitsValidation());
    }

    @Test
    void formatValidationTest() {
        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.formatValidation());

        nd = new NextDate("14/04-1997");
        assertEquals(false, nd.formatValidation());

        nd = new NextDate("14-04/1997");
        assertEquals(false, nd.formatValidation());

        nd = new NextDate("14-04-1997");
        assertEquals(false, nd.formatValidation());
    }

    @Test
    void dayValidationTest() {
        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.dayValidation());

        nd = new NextDate("00/04/1997");
        assertEquals(false, nd.dayValidation());

        nd = new NextDate("32/04/1997");
        assertEquals(false, nd.dayValidation());
    }

    @Test
    void monthValidationTest() {
        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.monthValidation());
        
        nd = new NextDate("14/00/1997");
        assertEquals(false, nd.monthValidation());

        nd = new NextDate("14/13/1997");
        assertEquals(false, nd.monthValidation());
    }

    @Test
    void yearValidationTest() {
        nd = new NextDate("14/04/1997");
        assertEquals(true, nd.yearValidation());

        nd = new NextDate("14/13/1599");
        assertEquals(false, nd.yearValidation());

        nd = new NextDate("14/13/9999");
        assertEquals(false, nd.yearValidation());
    }

    @Test
    void leapYearTest() {
        nd = new NextDate(null);
        assertTrue(nd.isLeapYear(2024));
        assertFalse(nd.isLeapYear(1900));
        assertTrue(nd.isLeapYear(2000));
        assertFalse(nd.isLeapYear(2019)); 
    }

    @Test
    void nextDateTest() {
        nd = new NextDate("14/04/1997");
        assertEquals("15/04/1997", nd.nextDate());

        nd = new NextDate("29/02/2024");
        assertEquals("01/03/2024", nd.nextDate());

        nd = new NextDate("28/02/2023");
        assertEquals("01/03/2023", nd.nextDate());

        nd = new NextDate("31/12/2024");
        assertEquals("01/01/2025", nd.nextDate());
    }
}