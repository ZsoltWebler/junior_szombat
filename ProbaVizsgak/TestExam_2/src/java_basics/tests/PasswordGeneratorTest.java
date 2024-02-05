package java_basics.tests;

import java_basics.PasswordGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordGeneratorTest {

    @Test
    public void testWeakPasswordOnlyContainsLowercaseLetters() {

        List<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            validCharacters.add((char) ('a' + i));
        }

        String weakPassword = PasswordGenerator.generateWeakPassword(20);

        for (char c : weakPassword.toCharArray()) {
            assertTrue(validCharacters.contains(c));
        }


    }

    @Test
    public void testWeakPasswordLength() {

        String weakPassword = PasswordGenerator.generateWeakPassword(20);

        assertEquals(20, weakPassword.length());
    }

    @Test
    public void testAveragePasswordOnlyContainsLowercaseLetters() {

        List<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            validCharacters.add((char) ('a' + i));
            validCharacters.add((char) ('A' + i));
        }

        String averagePassword = PasswordGenerator.generateAveragePassword(20);

        for (char c : averagePassword.toCharArray()) {
            assertTrue(validCharacters.contains(c));
        }


    }

    @Test
    public void testAveragePasswordLength() {

        String averagePassword = PasswordGenerator.generateAveragePassword(20);

        assertEquals(20, averagePassword.length());
    }

    @Test
    public void testStrongPasswordLength() {

        String strongPassword = PasswordGenerator.generateStrongPassword(20);

        assertEquals(20, strongPassword.length());
    }

    @Test
    public void testStrongPasswordOnlyContainsLettersAndNumbers() {

        List<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            validCharacters.add((char) ('a' + i));
            validCharacters.add((char) ('A' + i));
        }
        for (int i = 0; i < 10; i++) {
            validCharacters.add((char) (i + '0'));
        }

        String strongPassword = PasswordGenerator.generateStrongPassword(200);

        for (char c : strongPassword.toCharArray()) {
            assertTrue(validCharacters.contains(c));
        }


    }

    @Test
    public void testVeryStrongPasswordLength() {

        String veryStrongPassword = PasswordGenerator.generateVeryStrongPassword(20);

        assertEquals(20, veryStrongPassword.length());
    }

    @Test
    public void testVeryStrongPasswordOnlyContainsLettersAndNumbersAndSpecialCharacters() {

        List<Character> validCharacters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            validCharacters.add((char) ('a' + i));
            validCharacters.add((char) ('A' + i));
        }
        for (int i = 0; i < 10; i++) {
            validCharacters.add((char) (i + '0'));
        }
        for (char c : PasswordGenerator.SPECIAL_CHARACTERS) {
            validCharacters.add(c);
        }

        String veryStrongPassword = PasswordGenerator.generateVeryStrongPassword(200);

        for (char c : veryStrongPassword.toCharArray()) {
            assertTrue(validCharacters.contains(c));
        }


    }

}
