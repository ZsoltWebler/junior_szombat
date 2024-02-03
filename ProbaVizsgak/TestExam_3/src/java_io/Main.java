package java_io;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        EmissionReader.readEmissionFromCSV(new File("W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_3\\java_io\\emission.csv"));

    }
}
