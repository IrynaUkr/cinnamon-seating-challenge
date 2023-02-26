package org.example.service;

import org.example.model.Auditorium;
import org.example.model.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuditoriumServiceTest {
    AuditoriumService auditoriumService;
    Auditorium auditorium;

    @BeforeEach
    void setUp() {
        auditorium = new Auditorium();
        auditoriumService = new AuditoriumService(auditorium);
        auditoriumService.createAuditoriumSeats();
    }

    @Test
    void shouldCreateAuditoriumSeats() {
        List<Seat> auditoriumSeats = auditoriumService.auditorium.getSeats();

        assertEquals(15, auditoriumSeats.size());
        assertEquals('A', auditoriumSeats.get(0).getRow());
        assertEquals('B', auditoriumSeats.get(5).getRow());
        assertEquals('C', auditoriumSeats.get(10).getRow());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void shouldBookAvailableSeatIfDoesNotExistAllocated(int input, int expected) {

        auditoriumService.bookedSeats(input);
        long allocatedSeats = auditorium.getSeats().stream().filter(Seat::getIsAllocated).count();

        assertEquals(expected, allocatedSeats);
    }

    @Test
    void shouldBookAvailableSeatIfPresentAllocated() {
        ArrayList<Seat> seats = auditorium.getSeats();
        int allocatedSeats = 12;
        for (int i = 0; i < allocatedSeats; i++) {
            seats.get(i).setIsAllocated(true);
        }
        int bookedSeats = auditoriumService.bookedSeats(5).size();

        assertEquals(3, bookedSeats);
    }

    @Test
    void shouldCheckIfEnoughPlaceForBookingAllSeats(){
        assertFalse(auditoriumService.isEnoughSeatsForBooking(16));
        assertTrue(auditoriumService.isEnoughSeatsForBooking(15));
        assertTrue(auditoriumService.isEnoughSeatsForBooking(1));
    }

}
