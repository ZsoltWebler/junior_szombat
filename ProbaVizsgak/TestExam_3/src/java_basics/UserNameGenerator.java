package java_basics;

public class UserNameGenerator {

    public static String generateUserName(String lastName, String firstName, int yearOfBirth) {

        String userName = "";

        userName += lastName.substring(0, 1).toUpperCase();
        userName += firstName.substring(0, 2).toLowerCase();
        userName += "-";
        userName += Integer.toString(yearOfBirth).substring(3, 4);

        return userName;

    }

}
