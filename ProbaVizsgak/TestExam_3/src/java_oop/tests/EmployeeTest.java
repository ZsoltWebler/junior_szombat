package java_oop.tests;

import org.junit.jupiter.api.Test;
import java_oop.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {


    @Test
    public void testVacationDaysCalculatedCorrectlyIfEmployeeYoungerThan25() {
        Employee employee = new Employee("John", "Doe", 2000);

        int actual = employee.getNumberOfVacationDays();
        int expected = 20;

        assertEquals(expected, actual);
    }

    @Test
    public void testVacationDaysCalculatedCorrectlyIfEmployeeYoungerThan28() {
        Employee employee = new Employee("John", "Doe", 1997);

        int actual = employee.getNumberOfVacationDays();
        int expected = 21;

        assertEquals(expected, actual);
    }

    @Test
    public void testVacationDaysCalculatedCorrectlyIfEmployeeYoungerThan31() {
        Employee employee = new Employee("John", "Doe", 1996);

        int actual = employee.getNumberOfVacationDays();
        int expected = 22;

        assertEquals(expected, actual);
    }

    @Test
    public void testVacationDaysCalculatedCorrectlyIfEmployeeYoungerThan33() {
        Employee employee = new Employee("John", "Doe", 1993);

        int actual = employee.getNumberOfVacationDays();
        int expected = 23;

        assertEquals(expected, actual);
    }

    @Test
    public void testVacationDaysCalculatedCorrectlyIfEmployee33orOlder() {
        Employee employee = new Employee("John", "Doe", 1990);

        int actual = employee.getNumberOfVacationDays();
        int expected = 24;

        assertEquals(expected, actual);
    }


}
