package java_oop.tests;

import java_oop.OrderDetails;
import java_oop.OrderManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrdersManagerTest {

    OrderManager manager = new OrderManager(List.of(
            new OrderDetails(LocalDate.of(2024, 1, 20), "FUT_1", "6721 Tisza Lajos 7", LocalTime.of(8, 30)),
            new OrderDetails(LocalDate.of(2024, 1, 20), "FUT_1", "6721 Tisza Lajos 7", LocalTime.of(9, 30)),
            new OrderDetails(LocalDate.of(2024, 1, 20), "FUT_2", "6721 Tisza Lajos 7", LocalTime.of(10, 30)),
            new OrderDetails(LocalDate.of(2024, 1, 21), "FUT_1", "6721 Tisza Lajos 7", LocalTime.of(11, 30)),
            new OrderDetails(LocalDate.of(2024, 1, 21), "FUT_2", "6721 Tisza Lajos 7", LocalTime.of(12, 30)),
            new OrderDetails(LocalDate.of(2024, 1, 22), "FUT_3", "6700 Somogyi 8", LocalTime.of(13, 30))
    ));

    @Test
    public void testLeastAmountOrder() {
        LocalDate expected = LocalDate.of(2024, 1, 22);
        LocalDate actual = manager.leastAmountOrder();

        assertEquals(expected, actual);

    }

    @Test
    public void testGetOrderByDateAndTime() {
        OrderDetails expected = new OrderDetails(LocalDate.of(2024, 1, 20), "FUT_1", "6721 Tisza Lajos 7", LocalTime.of(8, 30));
        OrderDetails actual = manager.gerOrderByDateAndTime(LocalDate.of(2024, 1, 20), LocalTime.of(8, 30));

        assertEquals(expected, actual);
    }

    @Test
    public void testGetOrderByDateAndTimeShouldThrowException() {

       assertThrows(NoSuchElementException.class, () -> manager.gerOrderByDateAndTime(LocalDate.of(2024, 2, 20), LocalTime.of(8, 30)));

    }

    @Test
    public void testGetPostmanStatistics(){
        Map<String, Long> expected = Map.of("FUT_1",3L,"FUT_2",2L,"FUT_3",1L);
        Map<String, Long> actual = manager.getPostmanStatistics();

        assertEquals(expected, actual);
    }

    @Test
    public void testMostFavoredAddress(){
        String expected = "6721 Tisza Lajos 7";
        String actual = manager.mostFavoredAddress();

        assertEquals(expected, actual);
    }

}
