package org.example;

import org.example.model.Auditorium;
import org.example.model.Seat;
import org.example.service.AuditoriumService;

import java.util.List;

public class App {


    public static void main(String[] args) {
        Auditorium auditorium = new Auditorium();
        AuditoriumService auditoriumService = new AuditoriumService(auditorium);
        auditoriumService.createAuditoriumSeats();
        int amountSeats = 15;

        while (amountSeats > 0) {
            int max = 3;
            int min = 1;
            int seatsNumberOrder = (int)Math.floor(Math.random() * (max - min + 1) + min);
            List<Seat> seats = auditoriumService.bookedSeats(seatsNumberOrder);
            System.out.println("your requested ==> " + seatsNumberOrder+ " seat,  we book for you seats:");
            seats.forEach(System.out::println);
            amountSeats -= seats.size();
            System.out.println("now available " + amountSeats+ "seats amount ");
        }

    }

}