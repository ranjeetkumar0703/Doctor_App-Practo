package com.practo_Doctor_app.controller;

import com.practo_Doctor_app.payload_Dto.BookingDto;
import com.practo_Doctor_app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String>bookAppointement(@RequestBody BookingDto bookingDto){

        bookingService.bookAnAppointment(bookingDto);
        return new ResponseEntity<>("Booking is Confirmed:", HttpStatus.CREATED);


    }
}
