package java_oop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class OrderManager {

    private final List<OrderDetails> detailsList;

    public OrderManager(List<OrderDetails> detailsList) {

        this.detailsList = detailsList;
    }


    public LocalDate leastAmountOrder() {

        Map<LocalDate, Long> collect = detailsList.stream().collect(Collectors.groupingBy(OrderDetails::getOrderDate, Collectors.counting()));


        Long min = Long.MAX_VALUE;
        LocalDate candidate = null;

        for (LocalDate l : collect.keySet()) {
            if (collect.get(l) < min) {
                candidate = l;
                min = collect.get(l);
            }
        }

        return candidate;

    }

    public OrderDetails gerOrderByDateAndTime(LocalDate date, LocalTime time) {

        for (OrderDetails orderDetails : detailsList) {
            if (orderDetails.getOrderDate().equals(date) && orderDetails.getArrivalTime().equals(time)) {
                return orderDetails;
            }
        }

        throw new NoSuchElementException();

    }

    public Map<String, Long> getPostmanStatistics() {
        return detailsList.stream().collect(Collectors.groupingBy(OrderDetails::getPostmanId, Collectors.counting()));
    }

    public String mostFavoredAddress() {
        var addressMap = detailsList.stream().collect(Collectors.groupingBy(OrderDetails::getAddress, Collectors.counting()));

        Long max = Long.MIN_VALUE;
        String candidate = null;

        for (String s : addressMap.keySet()) {
            if (addressMap.get(s) > max) {
                candidate = s;
                max = addressMap.get(s);
            }
        }

        return candidate;

    }

}
