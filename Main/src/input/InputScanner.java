package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputScanner {

    /**
     * Method for getting year number from user.
     *
     * Every time wrong input (negative or not numeric) is entered, user is asked to reenter the year.
     * Scanner is closed after receiving valid input.
     *
     * @return entered year number as an int
     */
    public static int getYearInput() {
        final Scanner scanner = new Scanner(System.in);
        Integer input = null;
        boolean valid = false;
        while (!valid) {
                System.out.println("Sisesta aasta, mille kohta soovid tabelit genereerida:");
            try {
                input = scanner.nextInt();
                if (input >= 1991) {
                    valid = true;
                } else {
                    System.out.println("Spin TEK asutati 1991. aastal, sisesta hilisem aastaarv");
                }
            } catch (InputMismatchException e) {
                System.out.println("Sisestada number!");
                scanner.nextLine();  // Clear input stream
            }
        }
        scanner.close();
        return input;
    }
}
