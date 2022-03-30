package main.dates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Dates {
    private static final int PAYCHECK_DAY = 10;
    private static List<LocalDate> allHolidays;

    /**
     * Method for getting all paycheck dates of a particular year.
     *
     * If the 10th day of the month is a holiday or a weekend, the date is moved forward until it is on a workday.
     * @param year of request
     * @return list of paycheck dates
     */
    public static List<LocalDate> getPaycheckDates(final int year) {
        List<LocalDate> paycheckDates = new LinkedList<>();
        for (int i = 1; i <= 12; i++) {
            LocalDate date = LocalDate.of(year, i, PAYCHECK_DAY);
            while (isHoliday(date)) {
                date = date.plusDays(1);
            }
            paycheckDates.add(date);
        }
        return paycheckDates;
    }

    /**
     * Method for getting all reminder dates by paycheck dates.
     *
     * Reminders should be at least 3 work days before paycheck dates.
     * @param paycheckDates list of paycheck dates
     * @return list of reminder dates
     */
    public static List<LocalDate> getReminderDates(final List<LocalDate> paycheckDates) {
        List<LocalDate> reminderDates = new LinkedList<>();
        for (LocalDate paycheckDate: paycheckDates) {
            LocalDate reminderDate = paycheckDate;
            int workingDays = 0;
            while (workingDays < 3) {
                reminderDate = reminderDate.minusDays(1);
                workingDays += (isHoliday(reminderDate)) ? 0 : 1;
            }
            reminderDates.add(reminderDate);
        }
        return reminderDates;
    }

    /**
     * Checks if a date is on a holiday or on a weekend.
     * @param date of paycheck or reminder
     * @return false if date is a workday, else true
     */
    private static boolean isHoliday(final LocalDate date) {
        if (allHolidays == null) {
            allHolidays = getNationalHolidays(date.getYear());
        }
        final DayOfWeek day = date.getDayOfWeek();
        return allHolidays.contains(date) || day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    /**
     * Get all national holidays including moving ones.
     * @param year of holidays
     * @return list of holiday dates
     */
    private static List<LocalDate> getNationalHolidays(final int year) {
        List<LocalDate> allHolidays = Arrays.stream(NationalStaticHolidays.values())
                .filter(Objects::nonNull)
                .map(holiday -> holiday.getDate(year))
                .collect(Collectors.toList());
        // Add moving holidays
        LocalDate easter = getEaster(year);
        allHolidays.add(easter.minusDays(2));  // Big friday
        allHolidays.add(easter);
        allHolidays.add(easter.plusDays(50));  // Pentecost
        return allHolidays;
    }

    /**
     * Find easter date on a given year using Gauss' easter algorithm.
     *
     * About Gauss' algorithm: https://en.wikipedia.org/wiki/Date_of_Easter#Gauss's_Easter_algorithm
     * @param year of easter
     * @return date of easter
     */
    private static LocalDate getEaster(final int year) {
        float a, b, c, d, e, m, n, p, q;
        a = year % 19;
        b = year % 4;
        c = year % 7;
        p = (float)Math.floor(year / 100);
        q = (float)Math.floor((13 + 8 * p) / 25);
        m = (15 - q + 3 * p / 4) % 30;
        n = (4 + 3 * p / 4) % 7;
        d = (19 * a + m) % 30;
        e = (2 * b + 4 * c + 6 * d + n) % 7;
        int days = (int)(22 + d + e);
        int day;
        int month;
        // Corner cases
        if ((d == 29) && (e == 6)) {
            day = 19;
            month = 4;
        }
        else if ((d == 28) && (e == 6)) {
            day = 18;
            month = 4;
        }
        else if (days > 31) {
            day = days - 31;
            month = 4;
        }
        else {
            day = days;
            month = 3;
        }
        return LocalDate.of(year, month, day);
    }
}
