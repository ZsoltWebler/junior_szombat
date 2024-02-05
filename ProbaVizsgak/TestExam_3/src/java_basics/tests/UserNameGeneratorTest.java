package java_basics.tests;

import org.junit.jupiter.api.Test;
import java_basics.UserNameGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserNameGeneratorTest {


    @Test
    public void testUserNameGenerateFirstPart() {
        String generatedUserName = UserNameGenerator.generateUserName("Teszt", "Elek", 1996);
        String expected = "TEele";

        String actual = generatedUserName.substring(0, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void testUserNameGenerateLastPart() {
        String generatedUserName = UserNameGenerator.generateUserName("Teszt", "Elek", 1996);
        String expected = "96";
        String actual = generatedUserName.substring(6, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void testUserNameContainsSnake() {
        String generatedUserName = UserNameGenerator.generateUserName("Teszt", "Elek", 1996);
        assertTrue(generatedUserName.contains("_"));
    }

    @Test
    public void testUserNameGenerateV2Before2000() {
        String generatedUserName = UserNameGenerator.generateUserNameV2("Teszt", "Elek", 1996);
        String expected = "TEele_996";;
        assertEquals(expected, generatedUserName);
    }

    @Test
    public void testUserNameGenerateV2After2000() {
        String generatedUserName = UserNameGenerator.generateUserNameV2("Teszt", "Elek", 2001);
        String expected = "TEele_2001";
        assertEquals(expected, generatedUserName);
    }

}
