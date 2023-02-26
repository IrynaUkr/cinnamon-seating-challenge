package org.example.service;

import lombok.AllArgsConstructor;
import org.example.exception.NotEnoughSeatsException;
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
        auditorium.setAvailableSeats(seats.size());
        return seats;
    }

    public List<Seat> bookedSeats(int amountSeatsToBook) {
        List<Seat> seats = auditorium.getSeats();
        List<Seat> bookedSeats = new ArrayList<>();

        if (!isEnoughSeatsForBooking(amountSeatsToBook)) {
            throw new NotEnoughSeatsException("Sorry, we do not have amount Seats To Book " + amountSeatsToBook);
        }

        int i = 0;
        while (amountSeatsToBook > 0 && i < 15) {

            Seat currentSeat = seats.get(i);
            if (!currentSeat.getIsAllocated()) {
                currentSeat.setIsAllocated(true);
                bookedSeats.add(currentSeat);
                amountSeatsToBook--;
                decrementAvailableSeats();
            }
            i++;
        }
        return bookedSeats;
    }

    private void decrementAvailableSeats() {
        auditorium.setAvailableSeats(auditorium.getAvailableSeats() - 1);
    }

    public boolean isEnoughSeatsForBooking(int amountSeatsToBook) {
        return (auditorium.getAvailableSeats() - amountSeatsToBook) >= 0;
    }

}
