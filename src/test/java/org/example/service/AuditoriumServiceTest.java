package org.example.service;

import org.example.model.Auditorium;
import org.example.model.Seat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuditoriumServiceTest {
    AuditoriumService auditoriumService ;

    @BeforeEach
    void  setUp(){
        Auditorium auditorium = new Auditorium();
        auditoriumService = new AuditoriumService(auditorium);
    }

    @Test
    void createAuditoriumSeats() {
        List<Seat> auditoriumSeats = auditoriumService.createAuditoriumSeats();

        assertNotNull(auditoriumSeats);
    }

}