package java_io;

import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {



        List<Flight> flights = getFlights();

        FlightManager flightManager = new FlightManager(flights);
        System.out.println(flightManager.getMostMode());
        System.out.println(flightManager.getFlightById("KC9372"));
        System.out.println(flightManager.getFlightsByCityAndMode("Dublin", Mode.ARRIVAL));
        System.out.println(flightManager.getEarliestFlight());
        HashMap<Mode, List<Flight>> flightsByMode = flightManager.getFlightsByMode();

        BufferedWriter writer = new BufferedWriter(new FileWriter("arrival.txt"));
        BufferedWriter writer_2 = new BufferedWriter(new FileWriter("departure.txt"));
        for (Flight f : flightsByMode.get(Mode.ARRIVAL)) {

            writer.write(f.getId() + " " + f.getMode() + " " + f.getCity() + " " + f.getTime() +"\n");

        }
        for (Flight f : flightsByMode.get(Mode.DEPARTURE)) {

            writer_2.write(f.getId() + " " + f.getMode() + " " + f.getCity() + " " + f.getTime() +"\n");

        }

        writer.close();
        writer_2.close();


    }

    public static List<Flight> getFlights() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("W:\\Webler\\JuniorJava\\Git\\java\\Final\\src\\test_exam_1\\java_io\\cities.txt"));
        List<Flight> flights = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String id = scanner.next();
            String arrivalOrDeparture = scanner.next();
            String city = scanner.next();
            String timeAsString = scanner.next();
            String[] split = timeAsString.split(":");

            LocalTime time = LocalTime.parse(String.format("%02d", Integer.parseInt(split[0])) + ":" + String.format("%02d", Integer.parseInt(split[1])));

            flights.add(new Flight(id, arrivalOrDeparture.equals("Departure") ? Mode.DEPARTURE : Mode.ARRIVAL, city, time));


        }
        return flights;
    }
}
