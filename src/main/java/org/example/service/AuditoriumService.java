package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Auditorium;
import org.example.model.Seat;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AuditoriumService {
    Auditorium auditorium;

    public List<Seat> createAuditoriumSeats() {
        ArrayList<Seat> seats = auditorium.getSeats();
        for (char row = 'A'; row < 'D'; row++) {
            for (int seatNumber = 1; seatNumber < 6; seatNumber++) {
                seats.add(new Seat(row, seatNumber, false));
            }
        }
        auditorium.setSeats(seats);
        return seats;
    }

}
