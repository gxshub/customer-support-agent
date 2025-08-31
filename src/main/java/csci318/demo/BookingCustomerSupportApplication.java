package csci318.demo;

import csci318.demo.infrastructure.repository.BookingRepository;
import csci318.demo.infrastructure.repository.CustomerRepository;
import csci318.demo.model.Booking;
import csci318.demo.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BookingCustomerSupportApplication {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(BookingCustomerSupportApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadDatabase(BookingRepository bookingRepository,
                                          CustomerRepository customerRepository) throws Exception {
        return args -> {
            Customer customer1 = new Customer("John", "Doe");
            Booking booking1 = new Booking("MS-777",
                    LocalDate.of(2025, 12, 13),
                    LocalDate.of(2025, 12, 31),
                    customer1);
            customerRepository.save(customer1);
            System.out.println(customerRepository.findById(customer1.getCustomerId()).orElseThrow());
            bookingRepository.save(booking1);
            System.out.println(bookingRepository.findById(booking1.getBookingNumber()).orElseThrow());

            Customer customer2 = new Customer("David", "Smith");
            Booking booking2 = new Booking("AB-123",
                    LocalDate.of(2025, 9, 10),
                    LocalDate.of(2025, 9, 14),
                    customer2);
            customerRepository.save(customer2);
            System.out.println(customerRepository.findById(customer2.getCustomerId()).orElseThrow());
            bookingRepository.save(booking2);
            System.out.println(bookingRepository.findById(booking2.getBookingNumber()).orElseThrow());
        };
    }

}
