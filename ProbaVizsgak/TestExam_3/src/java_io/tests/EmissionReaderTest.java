package java_io.tests;

import java_io.CarEmissionInfo;
import java_io.EmissionReader;
import java_io.FuelType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class EmissionReaderTest {

    private final String filePath = "W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_3\\java_io\\emission.csv";
    List<CarEmissionInfo> carEmissionInfos = EmissionReader.readEmissionFromCSV(new File(filePath));

    public EmissionReaderTest() throws FileNotFoundException {
    }


    @Test
    public void carEmissionReadTest_1() {
        assertEquals(7385, carEmissionInfos.size());
    }

    @Test
    public void carEmissionReadTest_2() {
        assertEquals(new CarEmissionInfo("ACURA", "ILX", 2.0, FuelType.PREMIUM_GASOLINE, 196), carEmissionInfos.get(0));
        assertEquals(new CarEmissionInfo("CHEVROLET", "COLORADO 4WD", 2.8, FuelType.DIESEL, 280), carEmissionInfos.get(3500));
        assertEquals(new CarEmissionInfo("JAGUAR", "XF S AWD", 3.0, FuelType.PREMIUM_GASOLINE, 243), carEmissionInfos.get(7000));
    }

    @Test
    public void carEmissionReadTest_3() {
        assertEquals(42, carEmissionInfos.stream().map(CarEmissionInfo::getManufacturer).distinct().toList().size());
        assertEquals(2053, carEmissionInfos.stream().map(CarEmissionInfo::getModel).distinct().toList().size());
    }

    @Test
    public void carEmissionReadTest_4() {
        assertEquals(1460, carEmissionInfos.stream().map(CarEmissionInfo::getEngineSize).filter(engineSize -> engineSize.equals(2.0)).toList().size());
        assertEquals(24, carEmissionInfos.stream().map(CarEmissionInfo::getEngineSize).filter(engineSize -> engineSize.equals(2.8)).toList().size());
        assertEquals(804, carEmissionInfos.stream().map(CarEmissionInfo::getEngineSize).filter(engineSize -> engineSize.equals(3.0)).toList().size());
    }

    @Test
    public void carEmissionReadTest_5() {
        fail();
    }

    @Test
    public void carEmissionReadTest_6() {
        fail();
    }
}
