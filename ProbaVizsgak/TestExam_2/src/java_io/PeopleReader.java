package java_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PeopleReader {


    public static List<People> readPeoplesFromCsv(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        List<People> peopleList = new ArrayList<>();

        scanner.nextLine();
        while (scanner.hasNextLine()) {


            String line = scanner.nextLine();
            String[] split = line.split(",");
            int id = Integer.parseInt(split[0]);
            String firstName = split[1];
            String lastName = split[2];
            String email = split[3];
            Gender gender = split[4].equals("Male") ? Gender.MALE : Gender.FEMALE;
            String ip = split[5];


            peopleList.add(new People(id,firstName,lastName,email,gender,ip));
        }

        return peopleList;

    }

}
