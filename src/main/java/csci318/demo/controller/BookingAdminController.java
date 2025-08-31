package csci318.demo.controller;

import csci318.demo.model.Booking;
import csci318.demo.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingAdminController {

    private final BookingService bookingService;

    public BookingAdminController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/admin/bookings/{bookingNumber}")
    public Booking getBookingByNumber(@PathVariable String bookingNumber) {
        return bookingService.getBooking(bookingNumber);
    }

    @GetMapping("/admin/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.findAll();
    }
}
