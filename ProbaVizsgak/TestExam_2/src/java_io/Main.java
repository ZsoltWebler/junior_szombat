package java_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<People> people = PeopleReader.readPeoplesFromCsv(new File("W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_2\\java_io\\people.csv"));
        System.out.println();

    }
}
