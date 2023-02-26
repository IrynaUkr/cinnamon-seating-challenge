package org.example.model;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Auditorium {
    ArrayList<Seat> seats = new ArrayList<>();
    int availableSeats;
}
