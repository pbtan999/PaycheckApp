package main.dates;

import java.time.LocalDate;

public enum NationalStaticHolidays {
        NEW_YEAR(1, 1),
        INDEPENDENCE(2, 24),
        SPRING(5, 1),
        VICTORY(6, 23),
        MIDSUMMER(6, 24),
        REINDEPENCENDE(8, 20),
        CHRISTMAS(12, 24),
        CHRISTMAS_FIRST(12, 25),
        CHRISTMAS_SECOND(12, 26);

        private final int month;
        private final int day;

    /**
     * Static estonian holidays.
     * @param month that the holiday takes place in
     * @param day that the holiday takes place on
     */
        NationalStaticHolidays(final int month, final int day) {
            this.month = month;
            this.day = day;
        }

    /**
     * Get the formatted holiday date, 24th Dec returns null before 2005.
     * @param year of holiday
     * @return LocalDate of holiday or null
     */
        public LocalDate getDate(final int year) {
            //  24th of Dec was not a holiday before 2005.
            if (month == 12 && day == 24 && year < 2005) {
                return null;
            }
            return LocalDate.of(year, month, day);
        }
    }
