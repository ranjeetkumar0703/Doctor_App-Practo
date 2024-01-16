package com.practo_Doctor_app.service;

import com.practo_Doctor_app.entity.Booking;
import com.practo_Doctor_app.payload_Dto.BookingDto;
import com.practo_Doctor_app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class BookingService{

    @Autowired
    private BookRepository bookRepo;

    private List<String> availableTimeSlots = new ArrayList<>();

    public BookingService() {
        // Initialize the availableTimeSlots list
        availableTimeSlots.add("10:15 AM");
        availableTimeSlots.add("11:15 AM");
        availableTimeSlots.add("12:15 PM");
        availableTimeSlots.add("3:15 PM");
        availableTimeSlots.add("4:15 PM");

        // Schedule the task to add time slots every 24 hours
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Executing scheduled task every 24 hours...");
            addTimeSlots();
        }, 0, 24, TimeUnit.HOURS);
    }

    public void bookAnAppointment(BookingDto dto) {
        Booking booking = new Booking();
        String bookingTime = dto.getBookingTime();

        // Use iterator to safely remove elements
        Iterator<String> iterator = availableTimeSlots.iterator();
        while (iterator.hasNext()) {
            String slot = iterator.next();
            if (slot.equals(bookingTime)) {
                booking.setBookingTime(bookingTime);
                iterator.remove(); // Safely remove the element from the list
                break; // Exit the loop since we found a matching slot
            }
        }

        booking.setDoctorId(dto.getDoctorId());
        booking.setPatientId(dto.getPatientId());

        if (booking.getBookingTime() != null) {
            bookRepo.save(booking);
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Time Slot Not Available");
        }
    }

    private void addTimeSlots() {
        // Code to add time slots to the list
        availableTimeSlots.add("10:15 AM");
        availableTimeSlots.add("11:15 AM");
        availableTimeSlots.add("12:15 PM");
        availableTimeSlots.add("3:15 PM");
        availableTimeSlots.add("4:15 PM");
    }
}
