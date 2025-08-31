package csci318.demo.service;

import csci318.demo.infrastructure.repository.BookingRepository;
import csci318.demo.model.Booking;
import csci318.demo.model.BookingNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking getBooking(String bookingNumber) {
        return this.bookingRepository.findById(bookingNumber).orElseThrow(
                () -> new BookingNotFoundException(bookingNumber)
        );
    }

    public List<Booking> findAll() {
        return this.bookingRepository.findAll();
    }

    public Booking getBookingDetails(String bookingNumber, String customerName, String customerSurname) {
        Optional<Booking> optionalBooking = this.bookingRepository.findById(bookingNumber);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            this.validate(booking, customerName, customerSurname);
            return booking;
        } else {
            throw new BookingNotFoundException(bookingNumber);
        }
    }

    public void cancelBooking(String bookingNumber, String customerName, String customerSurname) {
        Optional<Booking> optionalBooking = this.bookingRepository.findById(bookingNumber);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            validate(booking, customerName, customerSurname);
            this.bookingRepository.deleteById(bookingNumber);
        } else {
            throw new BookingNotFoundException(bookingNumber);
        }
    }

    private void validate(Booking booking, String customerName, String customerSurname) {
        if (!booking.getCustomer().getName().equals(customerName)
                || !booking.getCustomer().getSurname().equals(customerSurname)) {
            throw new BookingNotFoundException(booking.getBookingNumber());
        }
    }

}
