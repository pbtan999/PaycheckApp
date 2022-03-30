package output;

import main.output.Writer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    private Path path1;
    private Path path2;
    private File existingFile;
    private File nonexistingFile;
    private static final String  EXISTING_TEMP_FILENAME = "existing.csv";
    private static final String NONEXISTING_TEMP_FILENAME = "nonexisting.csv";
    private static List<LocalDate> paycheckDates;
    private static List<LocalDate> reminderDates;
    private static String expectedOutput;

    /**
     * Set example paycheck, reminder dates and expected output.
     */
    @BeforeAll
    static void setWritingData() {
        paycheckDates = new ArrayList<>() {
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

        reminderDates = new ArrayList<>() {
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

        expectedOutput = """
                Paycheck dates,reminder dates
                2004-01-12,2004-01-07
                2004-02-10,2004-02-05
                2004-03-10,2004-03-05
                2004-04-12,2004-04-06
                2004-05-10,2004-05-05
                2004-06-10,2004-06-07
                2004-07-12,2004-07-07
                2004-08-10,2004-08-05
                2004-09-10,2004-09-07
                2004-10-11,2004-10-06
                2004-11-10,2004-11-05
                2004-12-10,2004-12-07""";
    }

    @TempDir
    Path tempDir;

    /**
     * Create temporary directory and files for testing purposes.
     */
    @BeforeEach
    void setUp() {
        try {
            path1 = tempDir.resolve(EXISTING_TEMP_FILENAME);
            path2 = tempDir.resolve(NONEXISTING_TEMP_FILENAME);
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }

        // Create file paths
        existingFile = path1.toFile();
        nonexistingFile = path2.toFile();

        // Create existing empty file
        try {
            existingFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void givenExistingFile_whenWritingToFile_thenReturnTrue() {
        assertTrue(Writer.writeDatesToCsvFile(existingFile.getAbsolutePath(), paycheckDates, reminderDates));
        assertEquals(expectedOutput, readFileContents(existingFile.toPath()));
    }

    @Test
    void givenNonexistingFile_whenWritingToFile_thenReturnTrue() {
        System.out.println(nonexistingFile.getAbsolutePath());
        assertTrue(Writer.writeDatesToCsvFile(nonexistingFile.getAbsolutePath(), paycheckDates, reminderDates));
        assertEquals(expectedOutput, readFileContents(nonexistingFile.toPath()));
    }

    /**
     * Test method for reading temporary file's content.
     * @param path of temporary file
     * @return content
     */
    private String readFileContents(Path path) {
        Scanner scanner = null;
        StringBuilder actualOutput = new StringBuilder();
        try {
            scanner = new Scanner(path);
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                actualOutput.append(scanner.nextLine())
                        .append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading temporary test file in " + this.getClass().getSimpleName());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return actualOutput.toString().strip();
    }
}
