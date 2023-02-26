package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class Seat {
    Character row;//A,B,C
    Integer seatNumber;//1-15
    Boolean isAllocated;
}
