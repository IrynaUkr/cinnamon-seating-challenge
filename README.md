### Cinnamon Cinemas Business Requirements

Setting the Scene
Program allocates seats to customers purchasing tickets for a movie theatre.
Cinnamon Cinemas provided some criteria for how the program should be built.

. The Cinnamon Cinemas Movie Theatre has 15 seats, arranged in 3 rows of 5
  Rows are assigned a letter from A to C
  Seats are assigned a number from 1 to 5

User Story
Theatre Manager allocates seats to customers and  can control reserved seating for the theatre

GIVEN a customer wants to request some tickets
WHEN they request a number of seats between 1 and 3 for a movie
THEN the customer should be allocated the required number of seats
from the available seats on the seating plan
AND the seats should be recorded as allocated

Program allocates seats based on a random integer “number of seats” between 1 and 3 from the available
seats starting from seat A1 and filling the auditorium from  left to right, front to back.

All seats are available for sale when the program starts
The program continues to allocate a random number of seats until it finds there are not enough seats
left to complete the request Once there are not enough seats available to be allocated then the program can halt
