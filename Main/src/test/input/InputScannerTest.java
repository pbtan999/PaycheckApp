package input;

import main.input.InputScanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputScannerTest {
    private static final int CORRECT_YEAR = 2020;
    private static final int INCORRECT_YEAR = 1800;
    private static final String NOT_A_NUMBER = "Letters123Symbols!@?";
    private static final String OUTPUT_QUESTION = "Sisesta aasta, mille kohta soovid tabelit genereerida:"
            + System.lineSeparator();
    private static final String OUTPUT_NOT_A_NUMBER = "Sisestada number!" + System.lineSeparator();
    private static final String OUTPUT_INCORRECT_YEAR = "Ettevõte asutati 1991. aastal, sisesta hilisem aastaarv."
            + System.lineSeparator();
    private ByteArrayOutputStream outputStream;

    /**
     * Clear output stream so all System.out.println() calls could be read for each test separately.
     */
    @BeforeEach
    public void setUpOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    private Scanner getScannerWithInput(int num) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(String.valueOf(num).getBytes());
        return new Scanner(inputStream);
    }

    private Scanner getScannerWithInput(String text) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(text.getBytes());
        return new Scanner(inputStream);
    }
    @Test
    void givenCorrectYear_whenGettingInput_thenReturnYear() {
        Scanner scanner = getScannerWithInput(CORRECT_YEAR);
        int year = InputScanner.getYearInput(scanner);
        assertEquals(OUTPUT_QUESTION, outputStream.toString());
        assertEquals(CORRECT_YEAR, year);
        scanner.close();
    }

    @Test
    void givenNonDigitsAndThenCorrectYear_whenGettingInput_thenReturnYear() {
        String input = NOT_A_NUMBER + System.lineSeparator() + CORRECT_YEAR + System.lineSeparator();
        Scanner scanner = getScannerWithInput(input);
        int year = InputScanner.getYearInput(scanner);
        assertEquals(CORRECT_YEAR, year);
        String expectedOutput = OUTPUT_QUESTION + OUTPUT_NOT_A_NUMBER + OUTPUT_QUESTION;
        assertEquals(expectedOutput, outputStream.toString());
        scanner.close();
    }

    @Test
    void givenIncorrectAndThenCorrectYear_whenGettingInput_thenReturnYear() {
        String input = INCORRECT_YEAR + System.lineSeparator() + CORRECT_YEAR + System.lineSeparator();
        Scanner scanner = getScannerWithInput(input);
        int year = InputScanner.getYearInput(scanner);
        String expectedOutput = OUTPUT_QUESTION + OUTPUT_INCORRECT_YEAR + OUTPUT_QUESTION;
        assertEquals(expectedOutput, outputStream.toString());
        assertEquals(CORRECT_YEAR, year);
        scanner.close();
    }
}
