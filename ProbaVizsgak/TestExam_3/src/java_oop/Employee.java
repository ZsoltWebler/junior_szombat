package java_oop;

import java.time.LocalDate;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int yearOfBirth;
    private final int numberOfVacationDays;
    private final int startingMonth;


    public Employee(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.numberOfVacationDays = calculateNumberOfVacationDays();
        this.startingMonth = 1;
    }

    public Employee(String firstName, String lastName, int yearOfBirth, int startingMonth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.startingMonth = startingMonth;
        this.numberOfVacationDays = calculateNumberOfVacationDays();
    }

    public int getNumberOfVacationDays() {
        return numberOfVacationDays;
    }

    private int calculateNumberOfVacationDays() {

        int currentAge = LocalDate.now().getYear() - yearOfBirth;
        int vacationDays = 20;

        if (currentAge < 25) {
            vacationDays += 0;
        } else if (currentAge < 28) {
            vacationDays += 1;
        } else if (currentAge < 31) {
            vacationDays += 2;
        } else if (currentAge < 33) {
            vacationDays += 3;
        } else {
            vacationDays += 4;
        }

        if (this.startingMonth < 4) {
            return vacationDays;
        } else if (this.startingMonth < 7) {
            return (int) Math.ceil(vacationDays * 0.75);
        } else if (this.startingMonth < 10) {
            return (int) Math.ceil(vacationDays * 0.5);
        } else {
            return (int) Math.ceil(vacationDays * 0.25);
        }

    }
}
