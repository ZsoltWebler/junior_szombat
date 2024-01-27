package java_io.tests;

import org.junit.jupiter.api.Test;
import java_io.Flight;
import java_io.FlightManager;
import java_io.Mode;

import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightManagerTests {

    public final FlightManager manager = new FlightManager(List.of(
            new Flight("1",Mode.ARRIVAL,"Dublin",LocalTime.of(18,30)),
            new Flight("2",Mode.ARRIVAL,"London",LocalTime.of(18,0)),
            new Flight("3",Mode.DEPARTURE,"Budapest",LocalTime.of(20,30)),
            new Flight("4",Mode.DEPARTURE,"Berlin",LocalTime.of(5,55)),
            new Flight("5",Mode.DEPARTURE,"Dublin",LocalTime.of(4,0))
    ));


    public FlightManagerTests() throws FileNotFoundException {
    }

    @Test
    public void getMostModeTest() {

        assertEquals(Mode.DEPARTURE, manager.getMostMode());

    }

    @Test
    public void getFlightByIdTest() {

        Optional<Flight> flightById = manager.getFlightById("3");

        assertTrue(flightById.isPresent());

        Flight flight = flightById.get();

        assertEquals("3", flight.getId());
        assertEquals(Mode.DEPARTURE, flight.getMode());
        assertEquals("Budapest", flight.getCity());
        assertEquals(LocalTime.parse("20:30"), flight.getTime());

    }

    @Test
    public void getFlightsByCityAndModeTest() {

        List<Flight> flights = manager.getFlightsByCityAndMode("Dublin", Mode.ARRIVAL);

        assertEquals(1, flights.size());

        for (Flight f : flights) {
            assertEquals(Mode.ARRIVAL, f.getMode());
            assertEquals("Dublin", f.getCity());
        }


    }

    @Test
    public void getEarliestFlightTest() {
        Optional<Flight> earliestFlight = manager.getEarliestFlight();

        assertTrue(earliestFlight.isPresent());

        Flight flight = earliestFlight.get();

        assertEquals("5", flight.getId());
        assertEquals(Mode.DEPARTURE, flight.getMode());
        assertEquals("Dublin", flight.getCity());
        assertEquals(LocalTime.parse("04:00"), flight.getTime());
    }

    @Test
    public void getFlightsByMode() {
        HashMap<Mode, List<Flight>> flightsByMode = manager.getFlightsByMode();
        List<Flight> arrivalFlights = flightsByMode.get(Mode.ARRIVAL);
        List<Flight> departureFlights = flightsByMode.get(Mode.DEPARTURE);

        assertEquals(2, arrivalFlights.size());
        assertEquals(3, departureFlights.size());

        for (Flight f : arrivalFlights) {
            assertEquals(Mode.ARRIVAL, f.getMode());
        }

        for (Flight f : departureFlights) {
            assertEquals(Mode.DEPARTURE, f.getMode());
        }
    }

}
