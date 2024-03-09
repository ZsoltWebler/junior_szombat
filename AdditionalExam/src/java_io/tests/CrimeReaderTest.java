package java_io.tests;

import org.junit.jupiter.api.Test;
import java_io.Crime;
import java_io.CrimeReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CrimeReaderTest {

    private final String filePath = "W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_5\\java_io\\atlcrime.csv";
    List<Crime> crimes = CrimeReader.readCrimesFromCSV(new File(filePath));


    public CrimeReaderTest() throws FileNotFoundException {
    }


    @Test
    public void carReaderTest_1() {
        assertEquals(32855, crimes.size());
    }

    @Test
    public void carReaderTest_2() {

        List<String> crimeCategories = crimes.stream().map(Crime::getCrimeCategory).distinct().toList();
        assertEquals(11, crimeCategories.size());
    }

    @Test
    public void carReaderTest_3() {
        Map<String, List<Crime>> neighborhoodPlanningUnits = crimes.stream().collect(Collectors.groupingBy(Crime::getNeighborhoodPlanningUnits));
        assertEquals(248, neighborhoodPlanningUnits.get("A").size());
        assertEquals(877, neighborhoodPlanningUnits.get("L").size());
        assertEquals(1305, neighborhoodPlanningUnits.get("X").size());
    }

    @Test
    public void carReaderTest_4() {
        fail();
    }

    @Test
    public void carReaderTest_5() {
        fail();
    }

    @Test
    public void carReaderTest_6() {
        fail();
    }
}
