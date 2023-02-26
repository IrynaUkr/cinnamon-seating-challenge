package org.example.service;

import org.example.model.Auditorium;
import org.example.model.Seat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuditoriumServiceTest {
    AuditoriumService auditoriumService;

    @BeforeEach
    void setUp() {
        Auditorium auditorium = new Auditorium();
        auditoriumService = new AuditoriumService(auditorium);
    }

    @Test
    void shouldCreateAuditoriumSeats() {
        List<Seat> auditoriumSeats = auditoriumService.createAuditoriumSeats();

        assertEquals(15, auditoriumSeats.size());
        assertEquals('A', auditoriumSeats.get(0).getRow());
        assertEquals('B', auditoriumSeats.get(5).getRow());
        assertEquals('C', auditoriumSeats.get(10).getRow());
    }

}