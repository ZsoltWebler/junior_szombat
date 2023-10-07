package pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        try {
            createOrderList(orders);
            System.out.println("Melyik napon volt a legkevesebb rendelés? " + dateOfLeastOrder(orders));
            System.out.println("getOrderByDateTime(2020, 12, 01, 12, 30): \n" + getDateByDateTime(orders,
                    LocalDateTime.of(2020, 12, 1, 12, 30)));
            /*System.out.println("getOrderByDateTime(2023, 12, 01, 12, 30): \n" + getDateByDateTime(orders,
                    LocalDateTime.of(2023, 12, 01, 12, 30)));*/
            System.out.println("Futárstatisztika: ");
            courierStats(orders).forEach(System.out::println);
            System.out.println("A legtöbb pizzát a " + mostOrdersAtAddress(orders) + " címre szállították");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (NoSuchElementException nsee){
            System.out.println("A kért időpontban nem volt rendelés");
        }
    }

    public static boolean isDate(String str){
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        df.setLenient(false);
        try {
            df.parse(str);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public static void createOrderList(List<Order> orders) throws FileNotFoundException {
        File file = new File("C:\\_Projects\\School\\Java_Zsolttal\\clone_test\\junior_szombat\\Practice\\orders.txt");
        Scanner sc = new Scanner(file);
        String line = sc.nextLine();

        while(sc.hasNextLine()){

            String[] splittedDate = line.split("\\.");
            LocalDate date = LocalDate.of(Integer.parseInt(splittedDate[0]),
                    Integer.parseInt(splittedDate[1]),
                    Integer.parseInt(splittedDate[2]));
            line = sc.nextLine();
            while(!isDate(line)){
                String courier = line;
                String[] addressParts = sc.nextLine().split(" ");
                String address = addressParts[0]+" "+addressParts[1]+" "+addressParts[2];
                LocalTime timeStamp = LocalTime.parse(addressParts[3]);
                Order order;
                order = new Order(date, courier, address, timeStamp);
                orders.add(order);

                if(sc.hasNextLine()){
                    line = sc.nextLine();
                }else{
                    break;
                }
            }
        }
    }

    public static LocalDate dateOfLeastOrder(List<Order> orders){
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getDate, Collectors.counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
    public static Order getDateByDateTime(List<Order> orders,LocalDateTime time) throws NoSuchElementException{
        LocalDate date = time.toLocalDate();
        LocalTime timeStamp = LocalTime.of(time.getHour(), time.getMinute(), time.getSecond());
        return orders.stream()
                .filter(order -> order.getDate().equals(date) && order.getTimeStamp().equals(timeStamp))
                .findFirst()
                .orElseThrow();
    }
    public static List<Map.Entry<String, Long>> courierStats(List<Order> orders){
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCourier, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();
    }
    public static String mostOrdersAtAddress(List<Order> orders){

        return orders.stream()
                .collect(Collectors.groupingBy(Order::getAddress, Collectors.counting()))
                .entrySet()
                .stream()
                .peek(System.out::println)
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }
}
