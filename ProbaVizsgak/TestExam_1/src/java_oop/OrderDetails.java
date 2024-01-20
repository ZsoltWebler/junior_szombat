package java_oop;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class OrderDetails {

    private final LocalDate orderDate;
    private final String postmanId;
    private final String Address;
    private final LocalTime arrivalTime;


    public OrderDetails(LocalDate orderDate, String postmanId, String address, LocalTime arrivalTime) {
        this.orderDate = orderDate;
        this.postmanId = postmanId;
        Address = address;
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public String getPostmanId() {
        return postmanId;
    }

    public String getAddress() {
        return Address;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDate=" + orderDate +
                ", postmanId='" + postmanId + '\'' +
                ", Address='" + Address + '\'' +
                ", arrivalTime=" + arrivalTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(orderDate, that.orderDate) && Objects.equals(postmanId, that.postmanId) && Objects.equals(Address, that.Address) && Objects.equals(arrivalTime, that.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, postmanId, Address, arrivalTime);
    }
}
