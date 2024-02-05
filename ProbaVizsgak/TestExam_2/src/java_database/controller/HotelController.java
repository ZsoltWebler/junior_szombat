package java_database.controller;

import java_database.repository.RoomCategoryRepository;
import java_database.repository.RoomRepository;
import java_database.view.Hotel;

public class HotelController {


    public HotelController(){
        RoomRepository roomRepository = new RoomRepository();
        RoomCategoryRepository roomCategoryRepository = new RoomCategoryRepository();

        Hotel hotel = new Hotel(roomRepository,roomCategoryRepository);
        hotel.setVisible(true);
    }



}
