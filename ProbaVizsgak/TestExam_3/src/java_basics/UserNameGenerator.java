package java_basics;

public class UserNameGenerator {

    public static String generateUserName(String lastName, String firstName, int yearOfBirth) {

        String userName = "";

        userName += lastName.substring(0, 2).toUpperCase();
        userName += firstName.substring(0, 3).toLowerCase();
        userName += "_";
        userName += Integer.toString(yearOfBirth).substring(2, 4);

        System.out.println(userName);

        return userName;

    }

    public static String generateUserNameV2(String lastName, String firstName, int yearOfBirth) {

        String userName = "";

        userName += lastName.substring(0, 2).toUpperCase();
        userName += firstName.substring(0, 3).toLowerCase();
        userName += "_";
        if(yearOfBirth < 2000){
            userName += Integer.toString(yearOfBirth).substring(1);
        }else{
            userName += Integer.toString(yearOfBirth);
        }


        return userName;

    }

}
