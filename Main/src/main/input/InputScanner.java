package main.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputScanner {
    private static final int YEAR_FOUNDED = 1991;
    private static final String OUTPUT_QUESTION = "Sisesta aasta, mille kohta soovid tabelit genereerida:";
    private static final String OUTPUT_NOT_A_NUMBER = "Sisestada number!";
    private static final String OUTPUT_INCORRECT_YEAR = "Ettevõte asutati 1991. aastal, sisesta hilisem aastaarv.";

    /**
     * Method for getting year number from user.
     *
     * Every time wrong input (negative or not numeric) is entered, user is asked to reenter the year.
     * Scanner is closed after receiving valid input.
     *
     * @return entered year number as an int
     */
    public static int getYearInput(Scanner scanner) {
        Integer input = null;
        boolean valid = false;
        while (!valid) {
                System.out.println(OUTPUT_QUESTION);
            try {
                input = scanner.nextInt();
                if (input >= YEAR_FOUNDED) {
                    valid = true;
                } else {
                    System.out.println(OUTPUT_INCORRECT_YEAR);
                }
            } catch (InputMismatchException e) {
                System.out.println(OUTPUT_NOT_A_NUMBER);
                scanner.nextLine();  // Clear input stream
            }
        }
        return input;
    }
}
