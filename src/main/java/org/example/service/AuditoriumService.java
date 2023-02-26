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

    public void bookSeat() {
        ArrayList<Seat> seats = auditorium.getSeats();
        int amountSeatsToBook = 1;
        int i = 0;
        while (amountSeatsToBook > 0 && i < 15) {

            Seat currentSeat = seats.get(i);
            if (!currentSeat.getIsAllocated()) {
                currentSeat.setIsAllocated(true);
                System.out.println(currentSeat + "was booked");
                amountSeatsToBook--;
            }
            i++;
        }

    }

}
