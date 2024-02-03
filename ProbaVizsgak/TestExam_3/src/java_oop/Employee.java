package java_oop;

import java.time.LocalDate;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int yearOfBirth;
    private final int numberOfVacationDays;


    public Employee(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.numberOfVacationDays = calculateNumberOfVacationDays();
    }

    public int getNumberOfVacationDays() {
        return numberOfVacationDays;
    }

    private int calculateNumberOfVacationDays() {

        int currentAge = LocalDate.now().getMonthValue() - this.yearOfBirth;
        int vacationDays = 20;

        if (currentAge < 25) {
            vacationDays = 0;
        } else if (currentAge < 27) {
            vacationDays += 1;
        } else if (currentAge <= 31) {
            vacationDays += 2;
        } else if (currentAge < 33) {
            vacationDays = 3;
        } else {
            vacationDays += 4;
        }

        return vacationDays;

    }
}
