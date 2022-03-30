package dates;

import main.dates.Dates;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatesTest {

    @Test
    void givenYear2004_whenGettingPaycheckDates_thenReturnDates() {
        List<LocalDate> expected = new ArrayList<>() {
            {
            add(LocalDate.of(2004, 1, 12));
            add(LocalDate.of(2004, 2, 10));
            add(LocalDate.of(2004, 3, 10));
            add(LocalDate.of(2004, 4, 12));
            add(LocalDate.of(2004, 5, 10));
            add(LocalDate.of(2004, 6, 10));
            add(LocalDate.of(2004, 7, 12));
            add(LocalDate.of(2004, 8, 10));
            add(LocalDate.of(2004, 9, 10));
            add(LocalDate.of(2004, 10, 11));
            add(LocalDate.of(2004, 11, 10));
            add(LocalDate.of(2004, 12, 10));
            }
        };
        List<LocalDate> actual = Dates.getPaycheckDates(2004);
        assertEquals(expected, actual);
    }

    @Test
    void givenYear2004_whenGettingReminderDates_thenReturnDates() {
        List<LocalDate> paycheckDates = new ArrayList<>() {
            {
                add(LocalDate.of(2004, 1, 12));
                add(LocalDate.of(2004, 2, 10));
                add(LocalDate.of(2004, 3, 10));
                add(LocalDate.of(2004, 4, 12));
                add(LocalDate.of(2004, 5, 10));
                add(LocalDate.of(2004, 6, 10));
                add(LocalDate.of(2004, 7, 12));
                add(LocalDate.of(2004, 8, 10));
                add(LocalDate.of(2004, 9, 10));
                add(LocalDate.of(2004, 10, 11));
                add(LocalDate.of(2004, 11, 10));
                add(LocalDate.of(2004, 12, 10));
            }
        };

        List<LocalDate> expectedReminderDates = new ArrayList<>() {
            {
                add(LocalDate.of(2004, 1, 7));
                add(LocalDate.of(2004, 2, 5));
                add(LocalDate.of(2004, 3, 5));
                add(LocalDate.of(2004, 4, 6));
                add(LocalDate.of(2004, 5, 5));
                add(LocalDate.of(2004, 6, 7));
                add(LocalDate.of(2004, 7, 7));
                add(LocalDate.of(2004, 8, 5));
                add(LocalDate.of(2004, 9, 7));
                add(LocalDate.of(2004, 10, 6));
                add(LocalDate.of(2004, 11, 5));
                add(LocalDate.of(2004, 12, 7));
            }
        };
        List<LocalDate> actual = Dates.getReminderDates(paycheckDates);
        assertEquals(expectedReminderDates, actual);
    }

    @Test
    void givenYear2005_whenGettingPaycheckDates_thenReturnDates() {
        List<LocalDate> expected = new ArrayList<>() {
            {
                add(LocalDate.of(2005, 1, 10));
                add(LocalDate.of(2005, 2, 10));
                add(LocalDate.of(2005, 3, 10));
                add(LocalDate.of(2005, 4, 11));
                add(LocalDate.of(2005, 5, 10));
                add(LocalDate.of(2005, 6, 10));
                add(LocalDate.of(2005, 7, 11));
                add(LocalDate.of(2005, 8, 10));
                add(LocalDate.of(2005, 9, 12));
                add(LocalDate.of(2005, 10, 10));
                add(LocalDate.of(2005, 11, 10));
                add(LocalDate.of(2005, 12, 12));
            }
        };
        List<LocalDate> actual = Dates.getPaycheckDates(2005);
        assertEquals(expected, actual);
    }

    @Test
    void givenYear2005_whenGettingReminderDates_thenReturnDates() {
        List<LocalDate> paycheckDates = new ArrayList<>() {
            {
                add(LocalDate.of(2005, 1, 10));
                add(LocalDate.of(2005, 2, 10));
                add(LocalDate.of(2005, 3, 10));
                add(LocalDate.of(2005, 4, 11));
                add(LocalDate.of(2005, 5, 10));
                add(LocalDate.of(2005, 6, 10));
                add(LocalDate.of(2005, 7, 11));
                add(LocalDate.of(2005, 8, 10));
                add(LocalDate.of(2005, 9, 12));
                add(LocalDate.of(2005, 10, 10));
                add(LocalDate.of(2005, 11, 10));
                add(LocalDate.of(2005, 12, 12));
            }
        };

        List<LocalDate> expectedReminderDates = new ArrayList<>() {
            {
                add(LocalDate.of(2005, 1, 5));
                add(LocalDate.of(2005, 2, 7));
                add(LocalDate.of(2005, 3, 7));
                add(LocalDate.of(2005, 4, 6));
                add(LocalDate.of(2005, 5, 5));
                add(LocalDate.of(2005, 6, 7));
                add(LocalDate.of(2005, 7, 6));
                add(LocalDate.of(2005, 8, 5));
                add(LocalDate.of(2005, 9, 7));
                add(LocalDate.of(2005, 10, 5));
                add(LocalDate.of(2005, 11, 7));
                add(LocalDate.of(2005, 12, 7));
            }
        };
        List<LocalDate> actual = Dates.getReminderDates(paycheckDates);
        assertEquals(expectedReminderDates, actual);
    }

    @Test
    void givenYear2024_whenGettingPaycheckDates_thenReturnDates() {
        List<LocalDate> expected = new ArrayList<>() {
            {
                add(LocalDate.of(2024, 1, 10));
                add(LocalDate.of(2024, 2, 12));
                add(LocalDate.of(2024, 3, 11));
                add(LocalDate.of(2024, 4, 10));
                add(LocalDate.of(2024, 5, 10));
                add(LocalDate.of(2024, 6, 10));
                add(LocalDate.of(2024, 7, 10));
                add(LocalDate.of(2024, 8, 12));
                add(LocalDate.of(2024, 9, 10));
                add(LocalDate.of(2024, 10, 10));
                add(LocalDate.of(2024, 11, 11));
                add(LocalDate.of(2024, 12, 10));
            }
        };
        List<LocalDate> actual = Dates.getPaycheckDates(2024);
        assertEquals(expected, actual);
    }

    @Test
    void givenYear2024_whenGettingReminderDates_thenReturnDates() {
        List<LocalDate> paycheckDates = new ArrayList<>() {
            {
                add(LocalDate.of(2024, 1, 10));
                add(LocalDate.of(2024, 2, 12));
                add(LocalDate.of(2024, 3, 11));
                add(LocalDate.of(2024, 4, 10));
                add(LocalDate.of(2024, 5, 10));
                add(LocalDate.of(2024, 6, 10));
                add(LocalDate.of(2024, 7, 10));
                add(LocalDate.of(2024, 8, 12));
                add(LocalDate.of(2024, 9, 10));
                add(LocalDate.of(2024, 10, 10));
                add(LocalDate.of(2024, 11, 11));
                add(LocalDate.of(2024, 12, 10));
            }
        };

        List<LocalDate> expectedReminderDates = new ArrayList<>() {
            {
                add(LocalDate.of(2024, 1, 5));
                add(LocalDate.of(2024, 2, 7));
                add(LocalDate.of(2024, 3, 6));
                add(LocalDate.of(2024, 4, 5));
                add(LocalDate.of(2024, 5, 7));
                add(LocalDate.of(2024, 6, 5));
                add(LocalDate.of(2024, 7, 5));
                add(LocalDate.of(2024, 8, 7));
                add(LocalDate.of(2024, 9, 5));
                add(LocalDate.of(2024, 10, 7));
                add(LocalDate.of(2024, 11, 6));
                add(LocalDate.of(2024, 12, 5));
            }
        };
        List<LocalDate> actual = Dates.getReminderDates(paycheckDates);
        assertEquals(expectedReminderDates, actual);
    }
}