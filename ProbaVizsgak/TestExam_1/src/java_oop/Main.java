package java_oop;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_szombat\\ProbaVizsgak\\TestExam_1\\src\\java_oop\\orders.txt"));
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        LocalDate orderDate = null;
        while (sc.hasNext()) {

            String line_1 = sc.nextLine();
            if (!line_1.startsWith("FUT")) {

                String line_2 = sc.nextLine();
                String line_3 = sc.nextLine();

                orderDate = parseDate(line_1);
                String address = parseAddress(line_3);
                LocalTime arrivalTime = parseArrivalTime(line_3);

                orderDetailsList.add(new OrderDetails(orderDate, line_2, address, arrivalTime));
            } else {
                String line_2 = sc.nextLine();

                String address = parseAddress(line_2);
                LocalTime arrivalTime = parseArrivalTime(line_2);

                orderDetailsList.add(new OrderDetails(orderDate, line_1, address, arrivalTime));


            }


        }

        OrderManager orderManager = new OrderManager(orderDetailsList);

        System.out.println(orderManager.leastAmountOrder());
        System.out.println(orderManager.gerOrderByDateAndTime(LocalDate.parse("2020-12-01"), LocalTime.parse("12:30")));
        //System.out.println(orderManager.gerOrderByDateAndTime(LocalDate.parse("2020-12-01"),LocalTime.parse("12:31")));
        System.out.println(orderManager.getPostmanStatistics());
        System.out.println(orderManager.mostFavoredAddress());

        System.out.println();
    }

    public static LocalDate parseDate(String s) {
        return LocalDate.parse(s.replace(".", "-"));
    }

    public static String parseAddress(String s) {
        String[] split = s.split(" ");
        StringBuilder address = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            address.append(split[i] + " ");
        }

        return address.toString().trim();
    }

    public static LocalTime parseArrivalTime(String s) {

        String[] split = s.split(" ");
        return LocalTime.parse(split[3]);
    }


}
