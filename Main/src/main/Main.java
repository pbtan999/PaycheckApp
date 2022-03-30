package main;

import main.dates.Dates;
import main.input.InputScanner;
import main.output.Writer;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    /**
     * main.Main method which asks for user main.input and generates a csv file.
     * @param args str
     */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int year = InputScanner.getYearInput(scanner);
        scanner.close();
        final List<LocalDate> paycheckDates = Dates.getPaycheckDates(year);
        final List<LocalDate> reminderDates = Dates.getReminderDates(paycheckDates);
        String filename = "generated-files/" + year + ".csv";
        if (Writer.writeDatesToCsvFile(filename , paycheckDates, reminderDates)) {
            System.out.println(year + ".csv fail genereeriti edukalt");
        } else {
            System.out.println(year + ".csv faili ei suudetud luua.");
        }
    }
}
