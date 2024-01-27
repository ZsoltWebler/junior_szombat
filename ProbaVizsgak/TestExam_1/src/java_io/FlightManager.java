package java_io;

import java.util.*;

public class FlightManager {

    private final List<Flight> flights;

    public FlightManager(List<Flight> flights) {
        this.flights = flights;
    }

    public Mode getMostMode() {

        long arrivalCount = flights.stream().filter(f -> f.getMode().equals(Mode.ARRIVAL)).count();
        long departureCount = flights.stream().filter(f -> f.getMode().equals(Mode.DEPARTURE)).count();

        if (arrivalCount > departureCount) {
            return Mode.ARRIVAL;
        } else {
            return Mode.DEPARTURE;
        }

    }

    public Optional<Flight> getFlightById(String id) {

        return flights.stream().filter(flight -> flight.getId().equals(id)).findFirst();

    }

    public List<Flight> getFlightsByCityAndMode(String city, Mode mode) {

        return flights.stream().filter(flight -> flight.getCity().equals(city) && flight.getMode().equals(mode)).toList();

    }

    public Optional<Flight> getEarliestFlight() {

        return flights.stream().min(Comparator.comparing(Flight::getTime));

    }

    public HashMap<Mode, List<Flight>> getFlightsByMode() {

        List<Flight> arrivalFlights = new ArrayList<>();
        List<Flight> departureFlights = new ArrayList<>();

        flights.forEach(flight -> {
            if (flight.getMode().equals(Mode.ARRIVAL)) {
                arrivalFlights.add(flight);
            } else {
                departureFlights.add(flight);
            }
        });

        return new HashMap<>(Map.of(Mode.ARRIVAL, arrivalFlights, Mode.DEPARTURE, departureFlights));

    }

}
