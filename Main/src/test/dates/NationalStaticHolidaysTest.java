package dates;

import main.dates.NationalStaticHolidays;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NationalStaticHolidaysTest {

    @Test
    void givenYear_whenGettingHolidayDate_thenReturnCorrectDate() {
        LocalDate expectedDate = LocalDate.of(2007, 2, 24);
        LocalDate actualDate = NationalStaticHolidays.INDEPENDENCE.getDate(2007);
        assertEquals(expectedDate, actualDate);
    }

    @Test
    void givenYearBefore2005_whenGettingChristmasDate_thenReturnNull() {
        LocalDate actualDate = NationalStaticHolidays.CHRISTMAS.getDate(2004);
        assertNull(actualDate);
    }

    @Test
    void givenYear2005_whenGettingChristmasDate_thenReturnDate() {
        LocalDate expectedDate = LocalDate.of(2005, 12, 24);
        LocalDate actualDate = NationalStaticHolidays.CHRISTMAS.getDate(2005);
        assertEquals(expectedDate, actualDate);
    }

    @Test
    void givenYearAfter2005_whenGettingChristmasDate_thenReturnDate() {
        LocalDate expectedDate = LocalDate.of(2006, 12, 24);
        LocalDate actualDate = NationalStaticHolidays.CHRISTMAS.getDate(2006);
        assertEquals(expectedDate, actualDate);
    }
}
