package output;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public final class Writer {
    /**
     * Method for writing paycheck and reminder dates to a csv file with name "{year}.csv" in generated-files directory.
     *
     * Paycheck and reminder dates should to be in the same order.
     * @param year filename "{year}.csv"
     * @param paycheckDates list of paycheck dates
     * @param reminderDates list of reminder dates
     */
    public static void writeDatesToFile(int year,
                                        final List<LocalDate> paycheckDates,
                                        final List<LocalDate> reminderDates) {
        final String output = generateDatesString(paycheckDates, reminderDates);
        try {
            final FileWriter writer = new FileWriter("generated-files/" + year + ".csv");
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds paycheck dates and reminder dates to .csv compatible form, seperated by a comma.
     * @param paycheckDates list of paycheck dates
     * @param reminderDates list of reminder dates
     * @return formatted string
     */
    private static String generateDatesString(List<LocalDate> paycheckDates, List<LocalDate> reminderDates) {
        final StringBuilder output = new StringBuilder();
        final String header = "Paycheck dates,reminder dates\n";
        output.append(header);
        for (int i = 0; i < 12; i++) {
            output.append(paycheckDates.get(i))
                    .append(",")
                    .append(reminderDates.get(i))
                    .append("\n");
        }
        return output.toString().strip();
    }
}
