package java_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmissionReader {


    public static List<CarEmissionInfo> readEmissionFromCSV(File file) throws FileNotFoundException {

        Scanner scanner = new Scanner(file);
        List<CarEmissionInfo> emissionInfos = new ArrayList<>();

        scanner.nextLine();
        while (scanner.hasNextLine()) {

            String[] split = scanner.nextLine().split(",");
            String manufacturer = split[0];
            String model = split[1];
            double engineSize = Double.parseDouble(split[3]);
            String fuelTypeCode = split[6];
            int co2Emission = Integer.parseInt(split[11]);


            FuelType fuelType = switch (fuelTypeCode) {
                case "X" -> FuelType.REGULAR_GASOLINE;
                case "Z" -> FuelType.PREMIUM_GASOLINE;
                case "D" -> FuelType.DIESEL;
                case "E" -> FuelType.E85;
                case "N" -> FuelType.NATURAL_GAS;
                default -> FuelType.UNKNOWN;
            };

            CarEmissionInfo info = new CarEmissionInfo(manufacturer, model, engineSize, fuelType, co2Emission);
            emissionInfos.add(info);

        }

        return emissionInfos;

    }

}
