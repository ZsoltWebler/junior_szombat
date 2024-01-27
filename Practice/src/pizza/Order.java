package pizza;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Order {
    LocalDate date;
    String courier;
    String address;
    LocalTime timeStamp;

    public Order(LocalDate date, String courier, String address, LocalTime timeStamp) {
        this.date = date;
        this.courier = courier;
        this.address = address;
        this.timeStamp = timeStamp;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCourier() {
        return courier;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                ", courier='" + courier + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(date, order.date) && Objects.equals(courier, order.courier) && Objects.equals(address, order.address) && Objects.equals(timeStamp, order.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, courier, address, timeStamp);
    }
}
